a = 1 + 2.5
# 整数没有大小限制
print(a)


print(r'I\'m ok.')


print('''a
line2
line3''')

print(r'''hello,\n
world''')

print(True)

print(False)

print(True and False)

print(not True)

print(None)

a = 'abc'
b = a
b = 'xyz'
print(a)

# python2.7直接取整
print(10/3)

# 地板除
print(10//3)

print('----------------------------------------------')
classmates = ['Michael', 'Bob', 'Tracy']
print(classmates)
print(len(classmates))
print(classmates[0])

#倒数第一个
classmates.append('Tony')
print(classmates[-1])

#删除倒数第一个
classmates.pop()
print(classmates)

#删除第一个
classmates.pop(1)
print(classmates)

#修改第一个
classmates[0] = '小明'
print(classmates)

#元素类型不同
classmates[1] = True
print(classmates)

print('-------------------------------')

#元组，不可变
t = (1, 2)
print(t)

#定义的是1
t0 = (1)
print(t0)

#加逗号才是元组
t1 = (1,)
print(t1)

s1 = set([1,2,3])
s2 = set([3,4,5])
print(s1 & s2)






