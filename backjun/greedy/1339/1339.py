import sys

N = int(sys.stdin.readline())
ch = []
col = {}
for i in range(N):
  tmp = sys.stdin.readline()[:-1]
  ch.append(tmp)
  for j in range(len(tmp)):
    if(col.get(tmp[j]) != None): 
      col[tmp[j]] += 10**(len(tmp)-1-j)
    else: col[tmp[j]] = 10**(len(tmp)-1-j)

col = dict(sorted(col.items(), key=lambda x:x[1], reverse=True))

num = 9
for key in col.keys():
  col[key] = str(num)
  num -= 1

result = 0
for ch_block in ch:
  tmp = ''
  for i in ch_block:
    tmp += col[i]
  result += int(tmp)
print(result)
