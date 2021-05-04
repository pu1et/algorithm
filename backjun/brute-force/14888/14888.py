import sys

def calc(arr):
  n = num[0]
  for i in range(len(arr)):
    if(op[arr[i]] == 0): n += num[i+1]
    elif(op[arr[i]] == 1): n -= num[i+1]
    elif(op[arr[i]] == 2): n *= num[i+1]
    else:
      if n <0: n = -1*(-1*n//num[i+1])
      else: n//=num[i+1]
  return n


def permutation(arr,idx):
  global result_min, result_max
  if(idx == len(op)):
    tmp = calc(arr)
    result_min = min(result_min,tmp) if result_min != None else tmp
    result_max = max(result_max,tmp) if result_max != None else tmp
  else:
    for i in range(len(op)):
      if not i in arr:
        permutation(arr+[i],idx+1)

N = int(sys.stdin.readline())
num = list(map(int,sys.stdin.readline()[:-1].split(" ")))
tmp = list(map(int,sys.stdin.readline()[:-1].split(" ")))
op = []
for i in range(len(tmp)):
  if i==0: op+=[0]*tmp[i]
  elif i==1: op+=[1]*tmp[i]
  elif i==2: op+=[2]*tmp[i]
  elif i==3: op+=[3]*tmp[i]

result_min, result_max = None, None

for i in range(len(op)):
  permutation([i],1)
print(result_max)
print(result_min)

