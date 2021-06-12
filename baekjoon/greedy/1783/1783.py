import sys

N, M = map(int,sys.stdin.readline().split())

if N == 1: result = 1
elif N == 2:
  if M <= 6: result = (M+1)//2 
  else: result = 4
else:
  if M <= 4: result = M
  elif M < 7: result = 4
  else: result = M-2
print(result)
