#coding=utf-8

import re
import requests
import urllib.request
import os

# 获取百度贴吧图片


# 获取 http 响应

def getResponse(url):

    # 请求头
    headers = {
        "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36"
    }

    # queryString
    data = {
    }

    response = requests.get(url, data = data, headers = headers)
    response.encoding = 'utf-8'

    return response

# 保存图片
def saveImages(html):
    reg = r'data-original="(.+?\.jpg)"  bpic='
    imgre = re.compile(reg)
    imglist = re.findall(imgre,html)

    # 文件夹不存在则创建
    if not os.path.isdir('images'):
        os.mkdir('images')

    i = 0
    for imgurl in imglist:
        urllib.request.urlretrieve(imgurl, 'images/%s.jpg' % i)
        i += 1


url = 'http://tieba.baidu.com/f?ie=utf-8&kw=ps&red_tag=o3478681093'

response = getResponse(url)

saveImages(response.text)


