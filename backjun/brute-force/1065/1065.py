import sys

N = int(sys.stdin.readline())
result = N

for i in range(100,N+1):
  tmp = str(i)
  diff = int(tmp[0]) - int(tmp[1])
  for j in range(1,len(tmp)-1):
    if(int(tmp[j]) - int(tmp[j+1]) != diff):
      result -= 1
      break
print(result)

