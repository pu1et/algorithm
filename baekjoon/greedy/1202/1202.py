import sys, heapq

N, M = map(int,sys.stdin.readline().split())
bags, jewels = [], []
for _ in range(N):
  tmp = list(map(int,sys.stdin.readline().split()))
  heapq.heappush(jewels, [tmp[0], tmp[1]])
for _ in range(M):
  bags.append(int(sys.stdin.readline()))

bags.sort()

result = 0
tmp_jew = []

for bag in bags:
  while jewels and bag >= jewels[0][0]:
    heapq.heappush(tmp_jew, -heapq.heappop(jewels)[1])
  if tmp_jew:
    result -= heapq.heappop(tmp_jew)
  elif not jewels: break

print(result)
