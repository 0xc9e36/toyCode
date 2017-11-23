import math

a = abs
b = a(-1)
print(b)

c = hex(16)
print(c)


#定义一个函数
def my_fun(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if(x <= 0):
        return -x
    else:
        return x

d = my_fun(5)
print(d)


#定义空函数
def nop():
    pass

def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny

#返回值是一个tuple
r = move(100, 100, 60, math.pi / 6)
print(r)


#def fact(n):
#    if n==1:
#        return 1
#    return n * fact(n - 1)

#num = fact(820)
#print(num)

#尾递归优化, python编译器并未实现
def fact(n):
    return fact_iter(n, 1)

def fact_iter(num, product):
    if num == 1:
        return product
    return fact_iter(num - 1, num * product)

num = fact(1000)
print(num)


