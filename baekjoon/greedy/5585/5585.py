N = 1000 - int(input())
coin = [500, 100, 50, 10, 5, 1]
cnt = 0
for i in range(6):
  cnt += N//coin[i]
  N %= coin[i]

print(cnt)

