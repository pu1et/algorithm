import sys

N, L = map(int,sys.stdin.readline().split())
thing = list(map(int, sys.stdin.readline().split()))
thing.sort()
result = 0

idx = 0
for t in thing:
  if idx < t:
    result += 1
    idx = t + L -1

print(result)
