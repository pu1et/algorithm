import sys

sys.setrecursionlimit(10**5)

def find(x):
  if parent[x] == x:
    return x
  else: 
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
  x = find(x)
  y = find(y)
  parent[x] = y
 
G = int(sys.stdin.readline())
P = int(sys.stdin.readline())
plane = [int(sys.stdin.readline()) for _ in range(P)]
parent = [i for i in range(G+1)]

result = 0
for p in plane:
  c = find(p)
  if c == 0: break
  else:
    result += 1
    union(c, c-1)
print(result)
