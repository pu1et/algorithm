import sys


N = int(sys.stdin.readline())
seat = list(sys.stdin.readline().rstrip())

cnt, idx, flag = 0, 0, 0
while idx < N:
  if flag == 0:
    if seat[idx] == 'S': 
      idx, cnt = idx+1, cnt+1
    else: 
      idx, cnt = idx+2, cnt+2
      flag = 1
  else:
    if seat[idx] == 'S': 
      idx, cnt = idx+1, cnt+1
    else: 
      idx, cnt = idx+2, cnt+1

print(cnt)

