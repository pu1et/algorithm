import sys

'''
도로를 이용할 때, 해당 도로 이전의 주유소 중 가장 저렴한 주유소의 기름을 사용하도록 한다
즉, 사용하던 주유소가 더 저렴하면 계속 그 기름으로 도로를 이용하고 
도착한 주유소가 더 저렴하면 그 주유소의 기름으로 교체한다

1. 처음 주유소를 가장 저렴한 주유소로 설정한다.
2. 주유소를 도착할 때마다 리터당 값을 비교하고,
   더 저렴한 주유소의 기름을 사용해 비용을 계산한다.
'''

N = int(sys.stdin.readline())
road = list(map(int, sys.stdin.readline().split()))
spot = list(map(int, sys.stdin.readline().split()))[:-1]

# 처음 주유소를 가장 저렴한 주유소로 설정
min_spot = spot[0]
result = 0

for i in range(len(spot)):
  # 주유소를 도착할 때마다 리터당 값 비교
  if min_spot > spot[i]:
    min_spot = spot[i]
  # 현재 위치 기준 가장 저렴한 주유소의 기름을 사용해 비용을 계산
  result += min_spot * road[i]
print(result)
