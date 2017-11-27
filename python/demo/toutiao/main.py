#coding：utf-8
import os
import random
from datetime import date

import requests
from requests import RequestException
from config import *
from bs4 import BeautifulSoup
from urllib.parse import urlencode
from pymongo import MongoClient
import json
import re
import codecs
import time


#抓取今日头条街拍图集，存入mongodb


#图集页面
def getIndexPageData(offset):
    params = {
        'offset': offset,
        'format': 'json',
        'keyword': '街拍',
        'autoload': True,
        'count': 20,
        'cur_tab': '3'
    }
    # 请求头
    headers = {
        "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36",
        "Host": "www.toutiao.com",
        "Cache-Control": "max-age=0",
        "Connection": "keep-alive",

    }
    params = urlencode(params, encoding='utf-8')
    url = 'https://www.toutiao.com/search_content?%s' % params
    try:
        response = requests.get(url, headers = headers)
        response.encoding = 'utf-8'
        if (200 == response.status_code):
            return response.text
        return None
    except RequestException as e:
        print('Request url list Exception')
        return None

#详情页
def getDetail(url):
    detail = requests.get(url)
    try:
        response = requests.get(url)
        response.encoding = 'utf-8'
        if (200 == response.status_code):
            return response.text
        return None
    except RequestException as e:
        print('Request detail Exception')
        return None

#解析图集页数据
def parseData(data):
    if 'data' in data.keys():
        for item in data.get('data'):
            yield item.get('article_url')

#解析详情页
def parseDetail(content, url):
    soup = BeautifulSoup(content, 'lxml')
    title = soup.select('title')[0].get_text()
    pattern = re.compile('gallery: JSON.parse\("(.*?)"\),',re.S)
    res = re.search(pattern, content)
    if res:
        str = codecs.decode(res.group(1),'unicode_escape')
        data_json = json.loads(str)
        if data_json and 'sub_images' in data_json.keys():
            sub_images = data_json.get('sub_images')
            images = [item.get('url') for item in sub_images]
            #下载图片
            for image in images:
                downloadImg(image)
            return {
                'title':title,
                'url':url,
                'images':images
            }

#存储到数据库
def save2Mongo(dict):
    if table.insert(dict):
        print(dict['title'],',',dict['url'],',存储到mongodb成功')
        return True
    return False


#下载图片
def downloadImg(imageUrl):
    try:
        response = requests.get(imageUrl)
        if (200 == response.status_code):
            saveImage(response.content)
    except RequestException as e:
        print('Request url list Exception')

#保存图片
def saveImage(content):
    path = '%s/images/img_rand%s_%s.%s' % (os.getcwd(),random.randint(1,1000), int(time.time()),'jpg')

    if not os.path.exists(path):
        with open(path,'wb') as f:
            f.write(content)
            f.close()

def main(offset = 0):

    content = getIndexPageData(offset)
    json_data = json.loads(content)

    # 数据获取完毕
    if None == json_data or 0 == json_data['return_count']:
        return None

    for url in parseData(json_data):

        # 外链
        if -1 == url.find('toutiao.com'):
            continue

        data = getDetail(url)
        if data:
            e = parseDetail(data, url)
            if e: save2Mongo(e)

if __name__ == '__main__':
    #连接数据库
    client = MongoClient(MONGO_HOST)
    db = client[MONGO_DB]
    table = db[MONGO_TABLE]

    for x in range(START, END):
        main(x * 20)
