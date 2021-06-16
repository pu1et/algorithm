import sys

case = int(sys.stdin.readline())
for _ in range(case):
  N, M = map(int, sys.stdin.readline().split())
  apply = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
  apply.sort(key=lambda x: x[1])

  book = [0]*(N+1)

  for i in range(M):
    for j in range(apply[i][0], apply[i][1]+1):
      if book[j] != 1:
        book[j] = 1
        break

  print(sum(book))

