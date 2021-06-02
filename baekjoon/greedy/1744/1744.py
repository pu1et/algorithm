import sys
from collections import deque

N = int(sys.stdin.readline())
result = 0
plus, minus = [], []
for _ in range(N):
  tmp = int(sys.stdin.readline())
  if tmp == 1: result += 1
  elif tmp > 0 : plus.append(tmp)
  else: minus.append(tmp)

plus.sort(reverse=True)
minus.sort()

plus = deque(plus)
minus = deque(minus)

for _ in range(len(plus)//2):
  result += plus.popleft() * plus.popleft()
if len(plus) > 0: result += plus.popleft()

for _ in range(len(minus)//2):
  result += minus.popleft() * minus.popleft()
if len(minus) > 0: result += minus.popleft()

print(result)


