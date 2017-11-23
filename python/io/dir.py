import os

#系统信息
name = os.name
uname = os.uname()
print(name)
print(uname)

#路径
path = os.path.abspath('.')
print(path)

#拼接路径
# os.path.join('../resource', 'testdir')
#新建文件夹
# os.mkdir('../resource/testdir')

#删除文件夹
os.rmdir('../resource/testdir')