import requests


# 请求头
headers = {
    "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/62.0.3202.62 Chrome/62.0.3202.62 Safari/537.36"
}

# 主机
host = 'http://www.hshfy.sh.cn/shfy/gweb/ktgg_search_content.jsp'

# queryString
data = {
    'yzm': 'P9cE',
    'ft':'',
    'ktrqks':'2017 - 11 - 21',
    'ktrqjs':'2017 - 12 - 21',
    'spc':'',
    'yg':'',
    'bg':'',
    'ah':'',
    'pagesnum': '1'
}


response = requests.get(host, data = data, headers = headers)
response.encoding = 'GBK'

print(response.text)