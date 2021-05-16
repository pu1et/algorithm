import sys

def bfs():
  queue = [start]
  visited[start] = 0
  while True:
    pop = queue.pop(0)
    if pop == end: return visited[pop]
    if pop+1 <= 100000 and visited[pop+1] == 0:
      queue.append(pop+1)
      visited[pop+1] = visited[pop] + 1
    if pop-1 >= 0 and visited[pop-1] == 0:
      queue.append(pop-1)
      visited[pop-1] = visited[pop] + 1
    if pop*2 <= 100000 and visited[pop*2] == 0:
      queue.append(pop*2)
      visited[pop*2] = visited[pop] + 1

start, end = list(map(int, sys.stdin.readline()[:-1].split(" ")))
visited = [0 for _ in range(100000+1)]

print(bfs())
