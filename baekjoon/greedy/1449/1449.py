import sys

'''
제일 낮은 위치부터 테이프를 붙여간다.

1. 물이 새는 위치를 오름차순 정렬한다.
2. 제일 낮은 위치부터 시작하여 테이프 수를 +1씩 해주고
   테이프의 길이만큼 위치를 증가시킨다. 
'''

N, L = map(int,sys.stdin.readline().split())
thing = list(map(int, sys.stdin.readline().split()))
result, idx = 0, 0

# 물이 새는 위치 오름차순 정렬
thing.sort()

# 제일 낮은 위치부터 테이프를 붙여감
for t in thing:
  if idx < t:
    result += 1
    idx = t + L -1

print(result)
