import sys

N = int(sys.stdin.readline()[:-1])

result = -1
for i in range(N//3+1):
  tmp = N - 3*i
  if tmp%5 ==0 :
    result = i + tmp//5
    break

print(result)

