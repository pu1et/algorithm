import sys, heapq

N, M = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))
heapq.heapify(card)

for _ in range(M):
  card1, card2 = heapq.heappop(card), heapq.heappop(card)
  new = card1 + card2
  heapq.heappush(card, new)
  heapq.heappush(card, new)

print(sum(card))
