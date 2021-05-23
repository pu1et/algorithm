import sys

def dfs(v):
  visited[v] = 1
  cnt = 1
  for i in range(1,N+1):
    if graph[v][i] == 1 and visited[i] == 0:
      cnt += dfs(i)
  return cnt
  
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
graph = [[0]*(N+1) for _ in range(N+1)]
visited = [0]*(N+1)

for _ in range(M):
  row, col = map(int, sys.stdin.readline().split())
  graph[row][col] = 1
  graph[col][row] = 1

print(dfs(1)-1)

  
