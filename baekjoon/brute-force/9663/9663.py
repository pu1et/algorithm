import sys

def solution(x):
  global result
  if(x>N):
    result += 1
    arr[x-1] = 0
    return

  for i in range(1,N+1):
    flag = 1
    arr[x] = i
    for j in range(1,x):
      if(i==arr[j] or abs(x-j) == abs(i-arr[j])):
          flag = 0
          break  
    if(flag == 1): solution(x+1)
    arr[x] = 0

N = int(sys.stdin.readline())
result = 0
arr = [0 for _ in range(N+1)]
solution(1)
print(result)

