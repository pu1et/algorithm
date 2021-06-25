import sys, heapq

N, C = map(int,sys.stdin.readline().split())
M = int(sys.stdin.readline())
box = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]

result = 0
heapq.heapify(box)
truck = [0]*(N+1)

for i in range(1,N+1):
    # 박스 놓기
    result += truck[i]

    load = [0]*(N+1)
    # 박스 싣기
    while box:
        if box[0][0] == i:
            pop = heapq.heappop(box)
            load[pop[1]] = pop[2]
        else: break
    check = C
    flag = False
    for j in range(i+1,N+1):
        if flag:
            truck[j] = 0
        else:
            if (truck[j] + load[j]) < check:
                check -= (truck[j] + load[j])
                truck[j] += load[j]
            else:
                truck[j] = check
                flag = True

print(result)
