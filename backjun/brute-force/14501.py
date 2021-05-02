import sys


def solution(start, money):
  if (start == N):
    if conf[start][0] == 1 : return money + conf[start][1]
    else: return money
  elif (start == N+1): return money
  elif (start > N): return 0 
  else:
    return max(solution(start+1,money),solution(start+conf[start][0],money+conf[start][1]))



N = int(sys.stdin.readline())

conf = [[0,0]]
for i in range(N):
  conf.append(list(map(int,sys.stdin.readline()[:-1].split(" "))))

print(solution(1,0))
