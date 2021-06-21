import sys
from queue import PriorityQueue

N, K = map(int, sys.stdin.readline().split())
K = N-K
tmp = list(map(int, sys.stdin.readline().rstrip()))
arr = PriorityQueue()

for i in range(N-K+1):
  arr.put([-tmp[i],i])

num, last_idx = arr.get()
print(-num, end='')

for i in range(N-K+1, N):
  arr.put([-tmp[i],i])
  while True:
    num, idx = arr.get()
    if last_idx < idx: 
      last_idx = idx
      break
  print(-num, end='')

