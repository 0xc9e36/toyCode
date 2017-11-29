from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from pyquery import PyQuery as pq
import re
from pymongo import MongoClient
from cnf import *

#模拟；浏览器抓取淘宝美食


#driver = webdriver.Chrome()


driver = webdriver.PhantomJS(service_args = SERVICE_ARGS)
driver.get("https://www.taobao.com")
wait = WebDriverWait(driver, 10)

driver.set_window_size(1400, 900)
#下一页
def next(page):
    print("下一页...")
    try:
        input = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.form > input'))
        )
        submit = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.form > span.btn.J_Submit'))
        )
        input.clear()
        input.send_keys(page)
        submit.click()

        wait.until(
            EC.text_to_be_present_in_element((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > ul > li.item.active > span'), str(page))
        )
    except TimeoutException:
        next(page)


def getItems():
    wait.until(
        EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-itemlist .items .item'))
    )

    html = driver.page_source
    doc = pq(html)

    items = doc('#mainsrp-itemlist .items .item').items()
    for item in items:
        product = {
            'title':item.find('.title').text(),
            'price':item.find('.price').text(),
            'image':item.find('.pic .img').attr('src'),
            'deal':item.find('.deal-cnt').text()[-3],
            'shop':item.find('.shop').text(),
            'location':item.find('.location').text()
        }
        save2Mongo(product)


#存储到数据库
def save2Mongo(dict):
    if table.insert(dict):
        print(dict['title'],',存储到mongodb成功')
        return True
    return False


#连接数据库
client = MongoClient(MONGO_HOST)
db = client[MONGO_DB]
table = db[MONGO_TABLE]

try:

    input = wait.until(
        EC.presence_of_element_located((By.ID, "q"))
    )

    submit = wait.until(
        EC.element_to_be_clickable((By.CSS_SELECTOR, '#J_TSearchForm > div.search-button > button'))
    )

    input.clear()
    input.send_keys('美食')

    submit.click()

    #总页数
    total = wait.until(
        EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.total'))
    )
    total = int(re.compile('(\d+)').search(total.text).group(1))
    for i in range(2, total + 1):
        getItems()
        next(i)

except TimeoutException as e:
    print(e.msg)

finally:
    driver.quit()



