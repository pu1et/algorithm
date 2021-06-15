import sys

def bt(row, col):
  if col == M-1: return 1
  else:
    ret = 0
    for i in range(3):
      r, c = row+p_r[i], col+1
      if 1<=r<=N and c<=M and graph[r][c] == '.':
        graph[r][c] = 'x'
        ret = bt(r,c)
        if ret == 1: return 1
    return 0

p_r = [-1,0,1]
N, M = map(int,sys.stdin.readline().split())
cnt = 0
graph = [['.']*(M+1)]

for _ in range(N):
  tmp = ['.']+list(sys.stdin.readline().rstrip())
  graph.append(tmp)

for i in range(2, N+1):
  if graph[i][2] == '.':
    ret = bt(i,2)
    if ret == 1: 
      cnt += 1

print(cnt)
