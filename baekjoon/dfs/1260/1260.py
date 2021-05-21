import sys
from collections import deque

def dfs(v):
  visited[v] = 1
  print(v, end=' ')
  for i in range(1,N+1):
    if graph[v][i] == 1 and visited[i] == 0:
      dfs(i)
    
def bfs(v):
  queue = deque()
  queue.append(v)
  visited[v] = 0
  while queue:
    pop = queue.popleft()
    print(pop, end=' ')
    for i in range(1,N+1):
      if graph[pop][i] == 1 and visited[i] == 1:
        queue.append(i)
        visited[i] = 0

N, M, V = map(int, sys.stdin.readline().split())
graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
  v1, v2 = map(int, sys.stdin.readline().split())
  graph[v1][v2] = 1
  graph[v2][v1] = 1

visited = [0]*(N+1)
dfs(V)
print()
bfs(V)



  
