import sys


N = int(sys.stdin.readline()[:-1])
tree = [0]
dp = []
for i in range(N):
  tmp = list(map(int,sys.stdin.readline()[:-1].split(" ")))
  for j in tmp:
    tree.append(j)

if(N == 1): print(tree[1])
else:
  dp = [0, tree[1]]
  for i in range(1,N):
    idx = int(i*(i+1)/2 + 1)
    for j in range(idx, idx+i+1):
      if j == idx: dp.append(dp[j-i]+tree[j])
      elif j == idx+i: dp.append(dp[j-(i+1)] + tree[j])
      else:
        if dp[j-(i+1)]>=dp[j-i]: dp.append(dp[j-(i+1)] + tree[j])
        else: dp.append(dp[j-i] + tree[j])

  idx = int((N-1)*N/2+1)
  tmp = []
  for i in range(idx, idx+N):
    tmp+=[dp[i]]
  print(max(tmp))
