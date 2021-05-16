import sys


N = int(sys.stdin.readline()[:-1])

dp, rgb = [], []
dp.append([0,0,0])
rgb.append([0,0,0])

for i in range(N):
  rgb.append(list(map(int,sys.stdin.readline()[:-1].split(" "))))

for i in range(1,N+1):
  tmp = []
  r, g, b = dp[i-1][0], dp[i-1][1], dp[i-1][2]
  tmp += [rgb[i][0] + g if g<=b else rgb[i][0] + b]
  tmp += [rgb[i][1] + r if r<=b else rgb[i][1] + b]
  tmp += [rgb[i][2] + r if r<=g else rgb[i][2] + g]
  dp.append(tmp)
  
print(min(dp[N]))
