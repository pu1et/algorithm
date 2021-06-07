import sys

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
spot = sorted(set(map(int, sys.stdin.readline().split())))
dist = [0] # 거리 
N = len(spot)

for i in range(1,N):
  dist.append(spot[i]-spot[i-1])
dist.sort()

if K<=N: print(sum(dist[:N-K+1]))
else: print(0)


