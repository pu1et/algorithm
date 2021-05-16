import sys, collections

def bfs():
  global queue, ripe
  p_r, p_c = [1,0,-1,0], [0,1,0,-1]
  while queue:
    row, col = queue.popleft()
    for i in range(4):
      r,c = row+p_r[i], col+p_c[i]
      if((r>=1 and r<=N) and (c>=1 and c<=M) and tomato[r][c]==0):
        queue.append([r,c])
        tomato[r][c] = tomato[row][col] + 1
        ripe -= 1
    if ripe == 0: return tomato[row][col] 
  return -1

M, N = list(map(int, sys.stdin.readline()[:-1].split(" ")))
tomato = [[0]*(M+1) for _ in range(N+1)]
ripe = N*M
queue = collections.deque([])
 
for i in range(1,N+1):
  tomato[i] = [0]+list(map(int,sys.stdin.readline()[:-1].split(" ")))
  for j in range(1,M+1):
    if tomato[i][j] == 1:
       queue.append([i,j])
       ripe -= 1
    elif tomato[i][j] == -1:
      ripe -= 1

if ripe == 0: print(0)
else:
  print(bfs())
