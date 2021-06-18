import sys

N = int(sys.stdin.readline())
arrow = list(map(int,sys.stdin.readline().split()))
result, cnt = 0, 0
comp = arrow[0]


for i in range(1,N):
  if comp > arrow[i]: cnt += 1
  else:
    result = max(result, cnt)
    comp = arrow[i]
    cnt = 0

result = max(result, cnt)
print(result)
