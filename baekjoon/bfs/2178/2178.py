import sys

def bfs():
  global visited
  queue = [[1,1]]
  visited[1][1] = 1
  result = 0
  while queue:
    row,col = queue.pop(0)
    if row == N and col == M: 
      result = min(result,visited[row][col]) if result != 0 else visited[row][col]
    else:
      r,c = [1,0,-1,0], [0,1,0,-1]
      for i in range(4):
        p_r, p_c = row+r[i], col+c[i]
        if(p_r >= 1 and p_r <= N) and (p_c >= 1 and p_c <= M):
          if visited[p_r][p_c] == 0 and graph[p_r][p_c] == 1: 
            visited[p_r][p_c] = visited[row][col] + 1
            queue.append([p_r,p_c])
  return result
  



N, M = list(map(int,sys.stdin.readline()[:-1].split(" ")))
graph = [[0]*(M+1) for _ in range(N+1)]
visited = [[0]*(M+1) for _ in range(N+1)]
for i in range(N):
  graph[i+1] = [0]+list(map(int,sys.stdin.readline()[:-1]))

print(bfs())

