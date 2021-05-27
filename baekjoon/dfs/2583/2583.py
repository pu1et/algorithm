import sys

sys.setrecursionlimit(10100)

def dfs(row, col):
  global graph
  graph[row][col] = 1
  ret = 1
  for i in range(4):
    r, c = row+p_r[i], col+p_c[i]
    if 0<=r<N and 0<=c<M and graph[r][c] == 0:
      ret += dfs(r,c)
  return ret
  
p_r, p_c = [1,0,-1,0], [0,1,0,-1]

N, M, cnt = map(int,sys.stdin.readline().split())
graph = [[0]*M for _ in range(N)]

for _ in range(cnt):
  x1,y1,x2,y2 = map(int,sys.stdin.readline().split())
  for i in range(y1,y2):
    for j in range(x1,x2):
      graph[i][j] = 1

result = []

for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      result += [dfs(i,j)]
print(len(result))
[print(i, end=' ') for i in sorted(result)]
