#import urllib.request
#
# proxy_handler = urllib.request.ProxyHandler({
#     'http': 'http://127.0.0.1:1080',
#     'https': 'https://127.0.0.1:1080'
# })
# opener = urllib.request.build_opener(proxy_handler)
# response = opener.open('http://icanhazip.com/')
#
# print(response)

import requests

# 请求头
headers = {
    "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36"
}

proxies = {
    'http': 'http://127.0.0.1:1080',
    'https': 'https://127.0.0.1:1080'
}

url = 'https://avgle.com/'

# 请求这样写
resp = requests.get(url, proxies = proxies, timeout = 5)

print(resp.text)

# 保存网页到test.html文件，resp.text就是返回的内容
# with open('test.html', mode='w') as f:
#     f.write(resp.text)


