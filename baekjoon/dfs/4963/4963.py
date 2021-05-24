import sys

sys.setrecursionlimit(2600)

def dfs(row, col):
  graph[row][col] = 0
  for i in range(8):
    r,c = row+p_r[i], col+p_c[i]
    if 1<=r<=N and 1<=c<=M and graph[r][c] == 1:
      dfs(r,c)


p_r, p_c = [1,0,-1,0,1,1,-1,-1], [0,1,0,-1,1,-1,1,-1]

while True:
  M, N = map(int,sys.stdin.readline().split())
  if M==0 and N==0: break
  else:
    island = 0
    graph = [[0]*(M+1) for _ in range(N+1)]
    for i in range(1,N+1):
      graph[i] = [0]+list(map(int, sys.stdin.readline().split()))

    for i in range(1,N+1):
      for j in range(1,M+1):
        if graph[i][j] == 1:
          island += 1
          dfs(i,j)

    print(island)
