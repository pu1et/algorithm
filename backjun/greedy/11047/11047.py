n,k = map(int,input().split(" "))
n_list = []
coin = 0
for i in range(n):
  n_list.append(int(input()))

for i in range(n-1,-1,-1):
  tmp = k//n_list[i]
  if(tmp > 0):
    k -= n_list[i]*tmp
    coin += tmp
    if(k == 0): break
print(coin)
