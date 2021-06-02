import sys, heapq

N = int(sys.stdin.readline())
card = []
result = 0
for _ in range(N):
  heapq.heappush(card, int(sys.stdin.readline()))

if N == 1: print(0)
else:
  while len(card) > 1:
    tmp1 = heapq.heappop(card)
    tmp2 = heapq.heappop(card)
    result += tmp1 + tmp2
    heapq.heappush(card, tmp1+tmp2)
    
  print(result)

