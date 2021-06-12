import sys

N, K = map(int,sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split(" ")))

tab = []
result = 0

for i in range(K):
  if not arr[i] in tab:
    if len(tab) < N:
      tab.append(arr[i])
    else:
      tmp = [101]*N
      for j in range(N):
        if tab[j] in arr:
          tmp[j] = arr.index(tab[j])
      tab[tmp.index(max(tmp))] = arr[i]
      result += 1
  arr[i] = 0

print(result)
