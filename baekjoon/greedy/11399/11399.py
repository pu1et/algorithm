'''
돈을 인출할 때 걸리는 시간이 이전 사람의 시간들의 누적값이 더해지므로
오름차순으로 정렬하여 각 인출시간을 더해주면 최소값이 된다.

1. 인출 시간을 오름차순 정렬한다.
2. 각 인출 시간을 더한다.
'''

n = int(input())
n_list = sorted(list(map(int, input().split(" ")))) # 인출 시간 오름차순 정렬
tmp = n_list[0]
sum = n_list[0]

# 각 인출 시간을 더함
for i in range(1,n):
  tmp += n_list[i]
  sum += tmp
print(sum)
