import sys

N, M = list(map(int,sys.stdin.readline().split(" ")))
card = list(map(int,sys.stdin.readline().split(" ")))

result = M
for i in range(len(card)-2):
  for j in range(i+1,len(card)-1):
    for k in range(j+1,len(card)):
      tmp = M - (card[i]+card[j]+card[k])
      if(tmp>=0 and result > tmp):
        result = tmp 

print(M-result)

