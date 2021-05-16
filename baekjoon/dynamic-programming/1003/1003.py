import sys
import operator


N = int(sys.stdin.readline()[:-1])

fib = [[1,0],[0,1]]
for i in range(2,40+1):
  fib.append(list(map(operator.add,fib[i-2],fib[i-1])))

for i in range(N):
  M = int(sys.stdin.readline()[:-1])
  print(str(fib[M][0]) + " " + str(fib[M][1]))
