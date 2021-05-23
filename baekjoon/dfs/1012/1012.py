import sys

def dfs(row, col):
  global graph
  graph[row][col] = 0
  for i in range(4):
    r, c = row+p_r[i], col+p_c[i]
    if 0<=r<N and 0<=c<M and graph[r][c] == 1:
      dfs(r,c)

sys.setrecursionlimit(2600)
test = int(sys.stdin.readline())
p_r, p_c = [1,0,-1,0], [0,1,0,-1]

for _ in range(test):
  M, N, K = map(int,sys.stdin.readline().split())
  graph = [[0]*M for _ in range(N)]
  house = 0

  for _ in range(K):
    col, row = map(int, sys.stdin.readline().split())
    graph[row][col] = 1

  for i in range(N):
    for j in range(M):
      if graph[i][j] == 1:
        house += 1
        dfs(i,j)
  print(house)
