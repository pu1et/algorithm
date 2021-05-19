import sys,copy
from itertools import combinations

def check(tmp,row,col):
  p_r, p_c = [1,0,-1,0],[0,1,0,-1]
  for i in range(4):
    c_r, c_c = row + p_r[i], col + p_c[i]
    if(c_r>=0 and c_r<N) and (c_c>=0 and c_c<M):
      if(tmp[c_r][c_c]==0):
        tmp[c_r][c_c] = 2
        check(tmp,c_r,c_c)

origin,zero,virus = [],[],[]
N,M = list(map(int,sys.stdin.readline()[:-1].split(" ")))
for i in range(N):
  ori = list(map(int,sys.stdin.readline()[:-1].split(" ")))
  for j in range(len(ori)):
    if(ori[j]==0): zero.append([i,j]) 
    elif(ori[j]==2): virus.append([i,j])
  origin.append(ori)

result = None

for i,j,k in combinations(zero,3):
  tmp = copy.deepcopy(origin)
  tmp[i[0]][i[1]] = 1
  tmp[j[0]][j[1]] = 1
  tmp[k[0]][k[1]] = 1
  for i in range(len(virus)):
    check(tmp,virus[i][0],virus[i][1])
  t = 0
  for i in range(N):
    t += tmp[i].count(0)
  result = max(t,result) if result != None else t

print(result)
