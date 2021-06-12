import sys

A, B = map(int,sys.stdin.readline().split())

result = 1
while B > A:
  tmp = str(B)
  if tmp[-1] == '1':
    B = int(tmp[:-1])
    result += 1
  elif B%2 == 0: 
    B //= 2
    result += 1
  else: break

print(result) if B == A else print(-1)
