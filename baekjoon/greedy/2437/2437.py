import sys

N = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split(" ")))
arr.sort()
num = 1

for i in arr:
  if num >= i: num += i
  else: break

print(num)
