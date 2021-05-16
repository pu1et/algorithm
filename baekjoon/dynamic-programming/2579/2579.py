import sys


N = int(sys.stdin.readline()[:-1])
stair = [0]
dp = []
for i in range(N):
  stair.append(int(sys.stdin.readline()[:-1]))

if(N == 1): print(stair[1])
elif(N == 2): print(stair[1]+stair[2])
else:
  dp = [0, stair[1], stair[1]+stair[2]]
  for i in range(3,N+1):
    tmp = []
    tmp += [dp[i-2] + stair[i]]
    tmp += [dp[i-3] + stair[i-1] + stair[i]]
    dp.append(max(tmp))
  print(dp[N])
