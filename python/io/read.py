
#读文件操作
# try:
#     # 获取文件对象
#     f = open('../resource/f.txt', 'r')
#     print(f.read())
# except IOError as e:
#     print('Except')
# finally:
#     if f:
#         f.close()

#with语句
# with open('../resource/f.txt', 'r', encoding='utf-8',  errors='ignore') as f:
#     if f:
#         print(f.read())


#二进制文件
f = open('../resource/0.jpg','rb')
content = f.read()

w = open('../resource/w.jpg', 'wb')

w.write(content)
f.close()
w.close()