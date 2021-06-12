import sys

'''
B에서 A로 바꾸는 연산을 한다.

1. 끝에 1이 있으면 잘라낸다.
2. 2의 배수면 나눈다.
3. 그 외 홀수는 2로 나누어떨어질 수 없기 때문에 -1출력
'''

A, B = map(int,sys.stdin.readline().split())

result = 1
while B > A:
  # 끝에 1 있으면 자름
  tmp = str(B)
  if tmp[-1] == '1':
    B = int(tmp[:-1])
    result += 1
  # 2의 배수면 나눔
  elif B%2 == 0: 
    B //= 2
    result += 1
  # 그 외 홀수는 2로 나누어떨어질 수 없기 때문에 -1 출력
  else: break

print(result) if B == A else print(-1)
