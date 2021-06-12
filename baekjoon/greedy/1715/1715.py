import sys, heapq

'''
합친 카드의 수만큼 계속 더해지기 때문에 수가 적은 카드 묶음부터 차례대로 카드를 섞는다.

1. 카드 묶음을 최소 힙(우선순위 큐)에 넣는다.
2. 힙에서 가장 수가 적은 카드 묶음 2개를 꺼내 합친다.
3. 합한 카드 묶음을 최소 힙(우선순위 큐)에 넣어준다.
'''

N = int(sys.stdin.readline())
card = []
result = 0

# 카드 묶음을 우선순위 큐에 넣음
for _ in range(N):
  heapq.heappush(card, int(sys.stdin.readline()))

if N == 1: print(0)
else:
  while len(card) > 1:
    # 힙에서 가장 수가 적은 카드 묶음 2개를 꺼내 합침
    tmp1 = heapq.heappop(card)
    tmp2 = heapq.heappop(card)
    result += tmp1 + tmp2
    # 합한 카드 묶음을 우선순위 큐에 넣음
    heapq.heappush(card, tmp1+tmp2)
    
  print(result)

