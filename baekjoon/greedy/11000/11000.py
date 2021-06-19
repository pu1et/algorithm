import sys, heapq


N = int(sys.stdin.readline())
arr = []
for _ in range(N):
  arr.append(list(map(int,sys.stdin.readline().split())))

arr.sort()
timeTable = [arr[0][1]]

for i in range(1,len(arr)):
  if timeTable[0] <= arr[i][0]:
    heapq.heappop(timeTable)
    heapq.heappush(timeTable, arr[i][1])
  else:
    heapq.heappush(timeTable, arr[i][1])
  
print(len(timeTable))
