import sys

'''
1과 0중 연속된 수를 바꿔야 하는 횟수가 더 적은 숫자를 뒤집으면 된다.

1. [0 연속 횟수, 1 연속 횟수] 배열을 생성한다.
2. 둘 중 더 작은 값을 출력한다.
'''

tmp = sys.stdin.readline().rstrip()
arr = [0,0]

flag = int(tmp[0])
arr[flag] += 1

# [0 연속 횟수, 1 연속 횟수] 배열 생성
for i in range(1,len(tmp)):
  if flag != int(tmp[i]): 
    flag = int(tmp[i])
    arr[flag] += 1
    
# 둘 중 더 작은 값 출력
print(min(arr))

