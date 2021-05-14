import sys

def bfs():
  visited = [0 for _ in range(N+1)]
  queue = [1]
  visited[1] = 1
  cnt = 0
  while queue:
    pop = queue.pop(0)
    for i in range(N+1):
      if computer[pop][i] == 1 and visited[i] == 0:
        queue.append(i)
        visited[i] = 1
        cnt += 1
  return cnt

N = int(sys.stdin.readline()[:-1])
M = int(sys.stdin.readline()[:-1])
computer = [[0]*(N+1) for _ in range(N+1)]

for i in range(M):
  row,col = list(map(int, sys.stdin.readline()[:-1].split(" ")))
  computer[row][col] = 1
  computer[col][row] = 1

print(bfs())
