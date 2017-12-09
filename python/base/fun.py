# def add_end(L=[]):
#     L.append('END')
#     return L
#
# print(add_end())
# print(add_end())
# print(add_end())


def add_end(L=None):
    if L is None:
        L = []
    L.append('END')
    return L

print(add_end())
print(add_end())
print(add_end())

def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum

s = calc(1, 2, 3)
print(s)