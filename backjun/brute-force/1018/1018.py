import sys


N,M = list(map(int,sys.stdin.readline().split(" ")))
chess = []
for i in range(N):
  chess.append(list(sys.stdin.readline()[:-1]))
b = ['B','W','B','W','B','W','B','W']
w = ['W','B','W','B','W','B','W','B']
result = 64

for row in range(N-7):
  for col in range(M-7):
    change_b, change_w = 0,0
    tmp1 ,tmp2 = b,w
    for i in range(8):
      change_b += sum(list(map(lambda x,y:0 if x==y else 1,chess[row+i][col:col+8],tmp1)))
      change_w += sum(list(map(lambda x,y:0 if x==y else 1,chess[row+i][col:col+8],tmp2)))
      tmp1= b if tmp1 == w else w
      tmp2= b if tmp2 == w else w
    result = min(result,min(change_b,change_w))

print(result)

