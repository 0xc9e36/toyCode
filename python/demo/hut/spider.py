#!/usr/bin/env python3
#-*- coding: utf-8 -*-

import requests
import pymysql.cursors
import json

def getInfo(stuno):
    url = 'http://218.75.197.122:84/search/exam/%s' % stuno

    headers = {
        'User-Agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36',
        'Cookie':'_csrf=ab2a2d2d2466ba7d64c79ca3bd6701c5b5b82b80b4f20ca3cf1ffcb8025ed07aa%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22SxAuZVESEjG0Yjc8nDsewI5kv9Ihij65%22%3B%7D',
        'X-Requested-With': 'XMLHttpRequest',
    }

    data = {
        '_csrf': 'MzBreml0eHlgSCoPMyI9KnZaLEowHhtBXXQYHx49TRJFCSISAB5OTA==',
    }
    try:
        response = requests.post(url, data=data, headers=headers)
        if response.status_code == 200 :
            return response.json()
    except Exception as e:
        print("出现异常,",e)


def parseInfo(stuno, json_data):
    if json_data and json_data['status'] != 'false':
        data = {
            'stuno': stuno,
            'stuname': json_data['stuname'],
            'stuclass': json_data['stuclass']
        }

        return data



def main():
    for pre in (144,154,164,174,):
        profession = range(1,100)
        for i in profession:
            for j in range(100, 1001):
                no = '%s%03d00%03d' % (pre, i, j)
                stuinfo = getInfo(no)
                data = parseInfo(no, stuinfo)
                print('搜索学号:', no,data)
                if data:
                    try:
                        insert(no, json.dumps(data, ensure_ascii=False))
                    except:
                        pass



def insert(stuno, json_data):
    sql = "INSERT INTO stuinfo(id, stuno, json_data) VALUES ( NULL , '%s', '%s' )"
    data = (stuno, json_data)
    cursor.execute(sql % data)
    connect.commit()
    print('成功插入', cursor.rowcount, '条数据')

# 连接数据库
connect = pymysql.Connect(
    host='localhost',
    port=3306,
    user='root',
    passwd='root',
    db='hut',
    charset='utf8'
)

# 获取游标
cursor = connect.cursor()

if __name__ == '__main__':
    main()
    # 关闭连接
    cursor.close()
    connect.close()



