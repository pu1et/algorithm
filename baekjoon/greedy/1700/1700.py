import sys

'''
1. 가장 나중에 변경하는 수 기준으로 변경
2. 이후에 가장 적게 사용되는 수 기준으로 변경
'''

N, K = map(int,sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split(" ")))

tab = []
result = 0

for i in range(K):
  if not arr[i] in tab: # 이미 있는 전기용품은 건너뛰기
    if len(tab) < N: # 탭에 전기용품 채우기
      tab.append(arr[i])
    else:
      tmp = [101]*N # 이후에 나타나지 않는 용품의 인덱스는 101
      
      #  이후에 전기용품이 가장 빨리 나타나는 인덱스 저장
      for j in range(N):
        if tab[j] in arr:
          tmp[j] = arr.index(tab[j])
      tab[tmp.index(max(tmp))] = arr[i] # tmp중 가장 나중에 변경되는 전기용품 교체
      result += 1
  arr[i] = 0 # 갔다온 표시

print(result)
