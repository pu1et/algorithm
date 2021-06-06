import sys, heapq

T = int(sys.stdin.readline())

for _ in range(T):
  N = int(sys.stdin.readline())
  arr = list(map(lambda x: -int(x), sys.stdin.readline().split()))
  heapq.heapify(arr)

  last = [heapq.heappop(arr)]*2
  diff = 0
  for_len = N//2 - 1 if N%2==0 else N//2

  for _ in range(for_len):
    pop = [heapq.heappop(arr), heapq.heappop(arr)]
    diff = max(diff, -last[0] + pop[0], -last[1] + pop[1])
    last = pop
  
  if N%2 == 0: 
    pop = heapq.heappop(arr)
    diff = max(diff, -last[0] + pop, -last[1] + pop)

  print(diff)


