import sys


N = int(sys.stdin.readline()[:-1])

for i in range(N):
  num = [0,1,2,4]
  M = int(sys.stdin.readline()[:-1])
  for j in range(4,M+1):
    num+=[num[j-3]+num[j-2]+num[j-1]]
  print(num[M])
