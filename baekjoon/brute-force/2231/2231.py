import sys

N = int(sys.stdin.readline())
result = 0
for i in range(N):
  tmp = list(map(int, str(i)))
  if(sum(tmp)+i == N):
    result = i;
    break

print(result)

