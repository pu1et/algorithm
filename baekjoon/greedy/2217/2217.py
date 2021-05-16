N = int(input())
K = []

W = 0
for i in range(N):
  K.append(int(input()))

K.sort()

for i in range(len(K)):
  tmp = K[i]*(len(K)-i)
  if(tmp>=W):
    W = tmp

print(W)
