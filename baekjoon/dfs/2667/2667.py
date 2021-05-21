import sys

def dfs(row,col,idx):
  graph[row][col] = 0
  house[idx] += 1
  for i in range(4):
    r,c = row + p_r[i], col + p_c[i]
    if 1<=r<=N and 1<=c<=N and graph[r][c] == 1:
      dfs(r,c,idx)
  
N = int(sys.stdin.readline())
graph = [[0]*(N+1) for _ in range(N+1)]
p_r, p_c = [1,0,-1,0], [0,1,0,-1]
house = []
for i in range(1,N+1):
  graph[i] = [0] + list(map(int, sys.stdin.readline().rstrip()))

for i in range(1,N+1):
  for j in range(1,N+1):
    if graph[i][j] == 1:
      house += [0]
      dfs(i,j,len(house)-1)

print(len(house))
for i in sorted(house):
  print(i)

  
