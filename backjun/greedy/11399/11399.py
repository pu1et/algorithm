n = int(input())
n_list = sorted(list(map(int, input().split(" "))))
tmp = n_list[0]
sum = n_list[0]
for i in range(1,n):
  tmp += n_list[i]
  sum += tmp
print(sum)
