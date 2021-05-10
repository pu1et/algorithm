import sys


N = int(sys.stdin.readline()[:-1])
fib = [0,1]
for i in range(2,N+1):
  fib+=[fib[i-2]+fib[i-1]]
print(fib[N])
