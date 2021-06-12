import sys

N = int(sys.stdin.readline())
result = 1

while result*(result+1)/2<= N:
  result += 1

print(result-1)
