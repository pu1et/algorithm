import sys


N = int(sys.stdin.readline()[:-1])
num = [0,0,1,1]
for i in range(4,N+1):
  tmp = []
  tmp += [num[i-1]+1]
  if i %3 ==0: tmp += [num[i//3]+1]
  if i %2 ==0: tmp += [num[i//2]+1]
  num += [min(tmp)] 

print(num[N])
