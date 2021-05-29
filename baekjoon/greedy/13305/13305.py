import sys

N = int(sys.stdin.readline())
road = list(map(int, sys.stdin.readline().split()))
spot = list(map(int, sys.stdin.readline().split()))[:-1]
min_spot = spot[0]
result = 0
for i in range(len(spot)):
  if min_spot > spot[i]:
    min_spot = spot[i]
  result += min_spot * road[i]
print(result)
