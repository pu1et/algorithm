import sys

def dfs(v):
  visited[v] = 1
  print(v,end=" ")
  for i in range(1,N+1):
    if visited[i] == 0 and graph[v][i] == 1:
      dfs(i)

def bfs(v):
  visited[v] = 1
  queue = [v]
  while queue:
    new = queue.pop(0)
    print(new,end=" ")
    for i in range(1,N+1):
      if visited[i] == 0 and graph[new][i] == 1:
        queue.append(i)
        visited[i] = 1


N, M, V = list(map(int,sys.stdin.readline()[:-1].split(" ")))
graph = [[0]*(N+1) for _ in range(N+1)]

for i in range(M):
  n1, n2 = list(map(int,sys.stdin.readline()[:-1].split(" ")))
  graph[n1][n2] = 1
  graph[n2][n1] = 1

visited = [0 for _ in range(N+1)]
dfs(V)
print()

visited = [0 for _ in range(N+1)]
bfs(V)
