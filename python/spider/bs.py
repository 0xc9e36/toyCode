from bs4 import BeautifulSoup
import urllib.parse
import urllib.request


response = urllib.request.urlopen('https://daily.zhihu.com/')
html_doc = response.read().decode('utf-8');

soup = BeautifulSoup(
    html_doc,
    'html.parser',
)

links = soup.find_all('a')

# 获取所有链接
for link in links:
    print(link.name, link['href'], link.get_text())


