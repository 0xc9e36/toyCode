import re

s = '010-12345'
mate = r'^\d{3}\-\d{3,8}$'

# 添加r可不用考虑字符串转义问题
result = re.match(mate, s)

if not result:
    print('匹配不对')
else:
    print('匹配正确')

print(result)

print('---------------------------')
# 切分
s1 = 'a b   c'.split(' ')
print(s1)

s2 = re.split(r'\s+', 'a b  c')
print(s2)

s3 = re.split(r'[\s,]+', 'a,b,  c d' )
print(s3)


s4 = re.split(r'[\s,;]+', 'a,b,  c;;; d')
print(s4)


# 分组
m = re.match(r'^(\d{3})(-)(\d{3,8})$', '010-12345')
print(m.group(2))

t = '19:05:30'
m1 = re.match(r'^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$', t)
ms = m1.groups()
print(ms)

# 贪婪匹配
g = re.match(r'^(\d+)(0*)$', '102300').groups()
print(g)

g1 = re.match(r'^(\d+?)(0*)$', '102300').groups()
print(g1)

print('------------------编译-------------------')
# 编译
re_telephone = re.compile(r'^(\d{3})-(\d{3,8})$')
g2 =  re_telephone.match('010-12345').groups();
print(g2)