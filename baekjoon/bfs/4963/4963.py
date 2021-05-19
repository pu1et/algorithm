import sys
from collections import deque

def bfs():
  cnt = 0
  for i in range(1,N+1):
    for j in range(1,M+1):
      if graph[i][j] == 1:
        queue = deque()
        queue.append([i,j])
        graph[i][j] = 0
        cnt += 1
        while queue:
          row, col = queue.popleft()
          for k in range(8):
            r,c = row+p_r[k], col+p_c[k]
            if 1<=r<=N and 1<=c<=M and graph[r][c] == 1:
              queue.append([r,c])
              graph[r][c] = 0
  return cnt

p_r, p_c = [1,0,-1,0,1,1,-1,-1], [0,1,0,-1,1,-1,1,-1]
while(True):
  M, N = map(int, sys.stdin.readline().split())
  if M==0 and N==0: break
  else:
    graph = [[0]*(M+1) for _ in range(N+1)]
    for i in range(1,N+1):
      graph[i] = [0] + list(map(int, sys.stdin.readline().split()))
    print(bfs())


  
