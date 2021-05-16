import sys


N = int(sys.stdin.readline()[:-1])
seq = list(map(int,sys.stdin.readline()[:-1].split(" ")))
dp = [1 for _ in range(N)]

for i in range(N):
  for j in range(i):
    if seq[i] > seq[j] and dp[i] < dp[j] + 1:
      dp[i] = dp[j] + 1

print(max(dp))
