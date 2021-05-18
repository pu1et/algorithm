import sys
from collections import deque

def bfs():
  cnt = 0
  queue = deque()
  for i in range(1,N+1):
    if not visited[i]:
      queue.append(i)
      visited[i] = 1
      cnt += 1
      while queue:
        pop = queue.popleft()
        for j in range(1,N+1):
          if graph[pop][j] == 1 and visited[j] == 0:
            queue.append(j)
            visited[j] = 1
  return cnt

N, M = map(int, sys.stdin.readline().split())
graph = [[0]*(N+1) for _ in range(N+1)]
visited = [0]*(N+1)

for _ in range(M):
  row, col = map(int, sys.stdin.readline().split())
  graph[row][col] = 1
  graph[col][row] = 1

print(bfs())
  
