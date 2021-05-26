import sys

sys.setrecursionlimit(10100)

def dfs(row, col):
  global copy_graph
  copy_graph[row][col] = 0
  for i in range(4):
    r,c = row+p_r[i], col+p_c[i]
    if 1<=r<=N and 1<=c<=N and copy_graph[r][c] > h:
      dfs(r,c)


p_r, p_c = [1,0,-1,0], [0,1,0,-1]


N = int(sys.stdin.readline())
graph = [[0]*(N+1) for _ in range(N+1)]
max_h = 0

for i in range(1,N+1):
  graph[i] = [0] + list(map(int, sys.stdin.readline().split()))
  if max_h < max(graph[i]): max_h = max(graph[i])

area = [0]*max_h

for h in range(max_h):
  copy_graph = [item[:] for item in graph]
  for i in range(1,N+1):
    for j in range(1,N+1):
      if copy_graph[i][j] > h:
        area[h] += 1
        dfs(i,j)    
print(max(area))
