import sys


N = int(sys.stdin.readline())
cent = [25, 10, 5, 1]

for _ in range(N):
  money = int(sys.stdin.readline())
  result = [0, 0, 0, 0]
  for i in range(4):
    result[i] = money//cent[i]
    money%=cent[i]
    if money == 0: break

  print(' '.join(str(r) for r in result))
