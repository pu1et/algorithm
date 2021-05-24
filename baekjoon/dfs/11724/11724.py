import sys

def dfs(v):
  global visited
  visited[v] = 1
  for i in range(1,N+1):
    if graph[v][i] == 1 and visited[i] == 0:
      dfs(i)

sys.setrecursionlimit(1100)
N, M = map(int,sys.stdin.readline().split())
graph = [[0]*(N+1) for _ in range(N+1)]
visited = [0]*(N+1)
cnt = 0

for _ in range(M):
  row, col = map(int, sys.stdin.readline().split())
  graph[row][col] = 1
  graph[col][row] = 1

for i in range(1,N+1):
  if visited[i] == 0:
    cnt += 1
    dfs(i)

print(cnt)
