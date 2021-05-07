import sys


N = int(sys.stdin.readline()[:-1])

block = [0,1,2]
for i in range(3,N+1):
  block+=[block[i-2]+block[i-1]]
print(block[N]%10007)
