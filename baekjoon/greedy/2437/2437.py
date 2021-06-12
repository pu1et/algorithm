import sys

'''
"배열의 다음 숫자가 누적합+1 이하라면 누적합+1 까지 숫자들은 기존 숫자들의 조합으로 모두 표현 가능하다" 법칙을 사용한다.

1. 배열을 오름차순으로 정렬한다.
2. 반복문을 실행하면서, 배열의 값이 누적합 초과일 경우 반복문을 나온다.
3. 누적합을 출력한다.
'''

N = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split(" ")))
# 배열 오름차순 정렬
arr.sort()
num = 1

# 배열의 값이 누적합 초과일 경우 반복문을 나옴
for i in arr:
  if num >= i: num += i
  else: break
    
# 누적합 출력
print(num)
