import http.cookiejar, urllib.request


cookie = http.cookiejar.LWPCookieJar()
cookie.load('../resource/cookie2.txt', ignore_discard=True, ignore_expires=True)


handler = urllib.request.HTTPCookieProcessor(cookie)
opener = urllib.request.build_opener(handler)
response = opener.open('http://www.zhihu.com')
print(response.read().decode('utf-8'))
