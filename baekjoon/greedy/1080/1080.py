import sys

'''
1. 행과 열을 증가시키며 행렬 B와 다른 요소가 있으면 3*3 단위로 0은 1로, 1은 0으로 교체해준다.
2. 결과적으로, 행렬 A와 B가 같지 않으면 -1을 출력한다.
'''

# 3*3 크기의 부분 행렬에 있는 모든 원소를 뒤집음
def change(row,col):
  for i in range(row, row+3):
    for j in range(col, col+3):
      origin[i][j] = 0 if origin[i][j] == 1 else 1

N, M = map(int,sys.stdin.readline().split(" "))
orgin, goal = [], []
origin = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
goal = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
result = 0

# 행과 열을 증가시키며 행렬 B와 다른 요소가 있으면 교체한 후, 연산 횟수 1 증가
for i in range(N-2):
  for j in range(M-2):
    if origin[i][j] != goal[i][j]:
      change(i,j)
      result += 1

# 연산 횟수 출력, but 행렬 A와 B가 같지 않으면 -1 출력
for i in range(N):
  for j in range(M):
    if origin[i][j] != goal[i][j]:
      result = -1
      break
  if result == -1: break

print(result)


