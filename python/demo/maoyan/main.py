#coding=utf-8

import re
import requests
import json
from multiprocessing import Pool


#获取 http 响应
def getResponse(url):
    response = requests.get(url, params = params, headers = headers)
    response.encoding = 'utf-8'

    return response


#获取一页的数据
def getOnePage(url):

    response = getResponse(url)

    reg = r'<dd>.*?board-index.*?>(\d+)</i>.*?img data-src="(.*?)".*?class="name"><a.*?>(.*?)</a>.*?class="star">(.*?)</p>' \
          r'.*?releasetime">(.*?)</p>.*?"integer">(.*?)</i><i class="fraction">(.*?)</i>.*?</dd>'

    pattern = re.compile(reg, re.S)

    items = re.findall(pattern, response.text);

    for item in items:
        yield {
            'index': item[0],
            'image': item[1],
            'title': item[2],
            'actor': item[3].strip()[3:],
            'time': item[4].strip()[5:],
            'score': item[5] + item[6]
        }
    return items


#写入文件
def writeFile(item):
    with open('data.txt', 'a', encoding='utf-8') as f:
        f.write(json.dumps(item, ensure_ascii=False) + '\n')
        f.close()


# 请求头
headers = {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36"
}
# 参数
params = {

}

def main(offset = 0):
    url = 'http://maoyan.com/board/4?offset=' + str(offset)
    items = getOnePage(url)
    for item in items:
        writeFile(item)



if __name__ == "__main__":
    for i in range(10):
        main(i * 10)
