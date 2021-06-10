import sys

tmp = sys.stdin.readline().rstrip()
arr = [0,0]

flag = int(tmp[0])
arr[flag] += 1

for i in range(1,len(tmp)):
  if flag != int(tmp[i]): 
    flag = int(tmp[i])
    arr[flag] += 1
print(min(arr))

