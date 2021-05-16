N = int(input())
conf = []

for i in range(N):
  conf.append(list(map(int,input().split(" "))))

conf.sort(key=lambda x: (x[1],x[0]))

cnt = 0
start = 0

for i in range(N):
  if(conf[i][0]>=start):
    start = conf[i][1]
    cnt += 1
print(cnt)
