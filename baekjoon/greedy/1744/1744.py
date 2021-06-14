import sys
from collections import deque

'''
최대값을 만들려면 양수는 양수끼리, 음수는 음수끼리 곱해서 더하면 된다.
예외 1) 0은 음수에 곱해주면 도움이 되므로 음수쪽에 넣어준다.
예외 2) 1은 어느 곳에 곱해도 그대로 값이 나오므로 그냥 더해준다.

1. 양수(>0)와  양수가 아닌 수(<=0)를 나눠서 저장한다. 단, 1은 더한다(양수, 음수 계산에 도움이 안되기 때문)
2. 양수 배열은 내림차순, 양수가 아닌 수 배열은 오름차순 정렬한다.(- * -는 +이기 때문) => 우선순위 큐 사용
3. 차례대로 2개씩 꺼내서 각각 결과값에 더한다.
'''

N = int(sys.stdin.readline())
result = 0
plus, minus = [], []

# 양수(>0)와  양수가 아닌 수(<=0)를 나눠서 저장하고, 1은 더함
for _ in range(N):
  tmp = int(sys.stdin.readline())
  if tmp == 1: result += 1
  elif tmp > 0 : plus.append(tmp)
  else: minus.append(tmp)

# 양수 배열은 내림차순, 양수가 아닌 수 배열은 오름차순 정렬 -> PriorityQueue를 사용해도 됨
plus.sort(reverse=True)
minus.sort()

plus = deque(plus)
minus = deque(minus)

# 양수를 저장한 큐에서 2개씩 꺼내면서 결과값에 더함
for _ in range(len(plus)//2):
  result += plus.popleft() * plus.popleft()
if len(plus) > 0: result += plus.popleft()

# 양수가 아닌 수를 저장한 큐에서 2개씩 꺼내면서 결과값에 더함
for _ in range(len(minus)//2):
  result += minus.popleft() * minus.popleft()
if len(minus) > 0: result += minus.popleft()

print(result)


