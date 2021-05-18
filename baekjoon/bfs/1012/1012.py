import sys, collections

def bfs():
  global graph
  p_r, p_c = [1,0,-1,0], [0,1,0,-1]
  house = 0
  for i in range(N):
    for j in range(M):
      if graph[i][j] == 1:
        house += 1
        queue = collections.deque()
        queue.append([i,j])
        graph[i][j] = 0
        while queue:
          row, col = queue.popleft()
          for k in range(4):
            r,c = row + p_r[k], col + p_c[k]
            if 0<=r<N and 0<=c<M and graph[r][c] == 1:
                queue.append([r,c])
                graph[r][c] = 0
  return house

test_num = int(sys.stdin.readline())

for _ in range(test_num):
  M, N, cnt = map(int, sys.stdin.readline().split())
  graph = [[0]*M for _ in range(N)]
  for _ in range(cnt):
    col, row = map(int, sys.stdin.readline().split())
    graph[row][col] = 1
  print(bfs())
  
