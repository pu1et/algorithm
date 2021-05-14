import sys

def bfs():
  for i in range(1,N+1):
    for j in range(1, N+1):
      if(visited[i][j] == 0 and graph[i][j] ==1):
        cnt = 1
        queue = [[i,j]]
        visited[i][j] = 1
        r,c = [1,0,-1,0], [0,1,0,-1]
        while queue:
          row, col = queue.pop(0)
          for k in range(4):
            p_r, p_c = row + r[k], col + c[k]
            if(p_r >= 1 and p_r <= N) and (p_c >=1 and p_c <= N):
              if(visited[p_r][p_c] == 0 and graph[p_r][p_c] == 1):
                queue.append([p_r,p_c])
                visited[p_r][p_c] = cnt + 1
                cnt += 1
        global house
        house.append(cnt)



N = int(sys.stdin.readline()[:-1])
graph = [[0]*(N+1) for _ in range(N+1)]
visited = [[0]*(N+1) for _ in range(N+1)]
house = []
for i in range(N):
  graph[i+1] = [0]+list(map(int,sys.stdin.readline()[:-1]))

bfs()
house.sort()
print(len(house))
print('\n'.join(str(i) for i in house)) if(len(house)) else print(0)

