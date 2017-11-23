from io import StringIO
from io import BytesIO

# f = StringIO()
# f.write('hello world')
# print(f.getvalue())


# f = StringIO('Hello!\nHi!\nGoodbye!')
#
# while True:
#     s = f.readline()
#     if s == '':
#         break
#     print(s.strip())

# f = BytesIO()
# f.write('中文'.encode('utf-8'))
# print(f.getvalue().decode('utf-8'))

f = BytesIO(b'\xe4\xb8\xad\xe6\x96\x87')
print(f.read().decode('utf-8'))