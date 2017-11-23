#coding=utf-8

import re
import requests
import urllib.request
import os


# 获取 http 响应
def getResponse(url):
    response = requests.get(url, params = params, headers = headers)
    #response.encoding = 'utf-8'

    return response


# 下载图片
def downloadImages(imglist):

    i = 0
    for imgurl in imglist:
        fileName = 'images/%s.jpg' % i
        r = requests.get(imgurl, headers = headers, stream=True)
        with open(fileName, 'wb') as f :
            for chunk in r.iter_content(1024):
                f.write(chunk)
        i = i + 1
    r.close()


#请求头
headers = {
    "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36"
}
#参数
params = {
}


url = 'http://image.baidu.com/search/index?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-8&word=%E7%BE%8E%E5%A5%B3'
response = getResponse(url)
response.encoding = 'utf-8'
print(response.text)

#　.+表示至少匹配一个字符，　?表示懒惰匹配
#reg = r'data-original="(.+?\.jpg)"  bpic='

reg = r'src="(.+?\.jpg)" style='
imgre = re.compile(reg)
imglist = re.findall(imgre, response.text)
print(imglist)
# 文件夹不存在则创建
if not os.path.isdir('images'):
    os.mkdir('images')

#downloadImages(imglist)
