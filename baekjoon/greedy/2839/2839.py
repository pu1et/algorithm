import sys

'''
3의 몫을 0 ~ N//3 까지 늘려가며 N%3이 5의 배수면 
3과 5의 각 몫을 넣어주고 for문을 빠져나온다.
-> i값이 증가할수록 결과값이 커지므로
'''

N = int(sys.stdin.readline()[:-1])

result = -1
for i in range(N//3+1):
  tmp = N - 3*i # == N%3
  if tmp%5 ==0 : # 최소 가방 수 이므로 break
    result = i + tmp//5 
    break

print(result)
