import sys

def change(row,col):
  for i in range(row, row+3):
    for j in range(col, col+3):
      origin[i][j] = 0 if origin[i][j] == 1 else 1

N, M = map(int,sys.stdin.readline().split(" "))
orgin, goal = [], []
origin = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
goal = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
result = 0

for i in range(N-2):
  for j in range(M-2):
    if origin[i][j] != goal[i][j]:
      change(i,j)
      result += 1


for i in range(N):
  for j in range(M):
    if origin[i][j] != goal[i][j]:
      result = -1
      break
  if result == -1: break

print(result)


