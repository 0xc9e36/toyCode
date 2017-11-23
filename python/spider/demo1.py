# GET请求方式
# import urllib.request
#
# response = urllib.request.urlopen('https://www.zhihu.com')
#
# data = response.read().decode('utf-8')
# print(data)



# POST请求方式
import socket
import urllib.parse
import urllib.request


data = bytes(urllib.parse.urlencode({'name': '王小仙'}), encoding='utf8')
print(data)
timeout = 20

status = None
content = None
try:
    response = urllib.request.urlopen('http://httpbin.org/post', data=data, timeout = timeout)
    content = response.read().decode('utf-8');
    status = response.status;
except urllib.error.URLError as e:
    if isinstance(e.reason, socket.timeout):
        print('TIME OUT')

print(status)
print(content)
