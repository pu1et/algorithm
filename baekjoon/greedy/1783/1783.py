import sys

'''
1. if 열 == 1, 방문할 수 있는 칸의 개수는 1이다.
2. if 열 == 2,
     if 행 <= 6, 3->2->3->2 방식으로 총 (행+1/2)만큼 방문할 수 있다.
     else 최대 4칸 방문할 수 있다.
3. if 열 > 2,
     if 1<=열<=4, 4->1->4->1 방식으로 총 열의 개수만큼 방문할 수 있다.
     else if 5<=가로<7, 위와 같은 방식으로 최대 4칸 방문할 수 있다. (2,3을 사용하면 4칸보다 줄어듦)
     else(>7), 총 5+M-7 = M-2 만큼 방문할 수 있다.
               시작 인덱스 1기준) 7열까지는 모든 이동 방법을 써야하기 때문에 5를 더하고,
               그 이후엔 4->1->4->1 방식으로 M-7만큼 방문이 가능하다.
'''

N, M = map(int,sys.stdin.readline().split())

if N == 1: result = 1
elif N == 2:
  if M <= 6: result = (M+1)//2 
  else: result = 4
else:
  if M <= 4: result = M
  elif M < 7: result = 4
  else: result = M-2
print(result)
