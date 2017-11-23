# 导入socket库:
import socket

# 创建一个socket:
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)


# 建立连接:
host = 'www.baidu.com'
port = 80
s.connect((host, port))

# 发送数据:
request = ('GET / HTTP/1.1\r\nHost: %s\r\nConnection: close\r\n\r\n' % host).encode('utf-8')

s.send(request)

# 接收数据:
buffer = []
while True:
    # 每次最多接收1k字节:
    d = s.recv(1024)
    if d:
        buffer.append(d)
    else:
        break

data = b''.join(buffer)

header, html = data.split(b'\r\n\r\n', 1)
print(header.decode('utf-8'))
# 把接收的数据写入文件:
with open('../../resource/baidu.html', 'wb') as f:
    f.write(html)