import sys

sys.setrecursionlimit(10100)

def dfs(row, col, val):
  global visited
  visited[row][col] = 1
  for i in range(4):
    r, c = row+p_r[i], col+p_c[i]
    if 0<=r<N and 0<=c<N and visited[r][c] == 0 and graph[r][c] == val:
      dfs(r,c,val)

def dfs_rgb(row, col, val):
  global visited
  visited[row][col] = 0
  for i in range(4):
    r, c = row+p_r[i], col+p_c[i]
    if 0<=r<N and 0<=c<N and visited[r][c] == 1 and graph_rgb[r][c] == val:
      dfs_rgb(r,c,val)
  
p_r, p_c = [1,0,-1,0], [0,1,0,-1]

N = int(sys.stdin.readline())
graph, graph_rgb = [], []
visited = [[0]*N for _ in range(N)]
result = [0,0]
for i in range(N):
  graph.append(list(sys.stdin.readline().rstrip()))
  graph_rgb.append(graph[i][:])
  for j in range(N):
    if graph[i][j] == 'G':
      graph_rgb[i][j] = 'R'

for i in range(N):
  for j in range(N):
    if visited[i][j] == 0:
      result[0] += 1
      dfs(i,j,graph[i][j])

for i in range(N):
  for j in range(N):
    if visited[i][j] == 1:
      result[1] += 1
      dfs_rgb(i,j,graph_rgb[i][j])

print("{} {}".format(result[0],result[1]))
