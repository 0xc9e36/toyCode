#!/usr/bin/env python3
# -*- coding: utf-8 -*-

print('中文')

s1 = 'ABC'.encode('ascii')
print(s1)

s2 = 'ABC'.encode('utf-8')
print(s2)

s3 = '中国'.encode('utf-8')
print(s3)

s3 = '中国'.encode('utf-16')
print(s3)

s4 = b'ABC'.decode('ascii')
print(s4)

s5 = b'\xff\xfe-N\xfdV'.decode('utf-16')
print(s5)

# 忽略错误
s6 = b'\xff\xfe-N\xfdV'.decode('ascii', errors='ignore')
print(s6)

str = 'A中国'

print('%02d-%02d' % (3, 1))
print('%.2f' % 3.1415926)
