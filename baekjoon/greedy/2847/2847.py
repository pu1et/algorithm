import sys

N = int(sys.stdin.readline())
arr = [int(sys.stdin.readline()) for _ in range(N)]

result = 0
score = arr[N-1]

for i in range(N-2, -1, -1):
  if score <= arr[i]:
    score -= 1
    result += arr[i] - score
  else:
    score = arr[i]

print(result)
