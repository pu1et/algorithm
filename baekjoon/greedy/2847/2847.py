import sys

'''
마지막 레벨부터 첫번째 레벨로 반복문을 돌며 점수를 조절한다.

1. 이전 점수보다 크면, 
   점수 = 이전 레벨 점수 -1 (이전 레벨보단 점수가 낮아야됨)
   결과값 += 현재레벨점수 - 점수
2. 이전 점수보다 작으면, 점수 = 현재 레벨 점수
'''

N = int(sys.stdin.readline())
arr = [int(sys.stdin.readline()) for _ in range(N)]

result = 0
score = arr[N-1]

for i in range(N-2, -1, -1):
  # 이전 점수보다 크면, 점수 = 이전 레벨 점수 -1 (이전 레벨보단 점수가 낮아야됨)
  if score <= arr[i]:
    score -= 1
    result += arr[i] - score
  # 이전 점수보다 작으면, 점수 = 현재 레벨 점수
  else:
    score = arr[i]

print(result)
