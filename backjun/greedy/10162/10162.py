import sys
T = int(sys.stdin.readline())
result = [5*60,60,10]

for i in range(3):
  tmp = result[i]
  result[i] = str(T // result[i])
  T %= tmp
if(T > 0): print("-1")
else: print(" ".join(result))

