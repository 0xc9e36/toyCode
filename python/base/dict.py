d = {'Michael': 95, 'Bob': 75, 'Tracy': 85}
print(d['Michael'])
print('pick' in d)

#不存在返回None
print(d.get('pick'))

#不存在返回指定值
print(d.get('pick', -1))

#删除

d.pop('Bob')
print(d)

#占内存，空间换时间


print('------------------------------')
s = set([1, 2, 3])
print(s)

#添加
s.add(4)
print(s)

#移除
s.remove(1)

str = 'abc';
str1 = str.replace('a', 'A')
print(str1)
