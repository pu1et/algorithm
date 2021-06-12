import sys, heapq

'''
각 가방에 들어갈 수 있는 무게의 보석 중 가장 가격이 나가는 것을 넣으면 된다.  

1. 보석은 보석 무게 기준 오름차순 정렬, 가방은 가방에 담을 수 있는 무게 기준으로 오름차순 정렬한다.
2. 가방을 반복문으로 돌면서 현재 가방에 담을 수 있는 최대 무게보다 작은 무게를 가진 모든 보석을
   꺼내서 보석 가격을 기준으로 최대 힙에 넣는다.
3. 최대 힙에서 꺼낸 보석의 가격을 결과값에 더해준다.
'''

N, M = map(int,sys.stdin.readline().split())
bags, jewels = [], []

# 보석은 보석 무게를 기준으로 오름차순 정렬
for _ in range(N):
  tmp = list(map(int,sys.stdin.readline().split()))
  heapq.heappush(jewels, [tmp[0], tmp[1]])
for _ in range(M):
  bags.append(int(sys.stdin.readline()))

# 가방은 가방에 담을 수 있는 무게 기준으로 오름차순 정렬
bags.sort()

result = 0
tmp_jew = []

for bag in bags:
  # 현재 가방에 담을 수 있는 최대 무게보다 작은 무게를 가진 모든 보석을 꺼내 보석 가격을 기준으로 최대 힙에 넣음
  while jewels and bag >= jewels[0][0]:
    heapq.heappush(tmp_jew, -heapq.heappop(jewels)[1])
  # 최대 힙에서 꺼낸 보석의 가격을 결과값에 더함
  if tmp_jew:
    result -= heapq.heappop(tmp_jew)
  # 보석이 없으면 반복문을 나감
  elif not jewels: break

print(result)
