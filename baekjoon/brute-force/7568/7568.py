import sys


N = int(sys.stdin.readline())
people = []
result = [1]*N
for i in range(N):
  people.append(sys.stdin.readline()[:-1].split(" "))

for idx in range(N):
  for i in range(N):
    if(people[idx][0] < people[i][0]) and (people[idx][1] < people[i][1]):
      result[idx] += 1

print(" ".join(str(i) for i in result))
