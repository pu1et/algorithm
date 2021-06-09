import sys

text = list(sys.stdin.readline().rstrip())
find = ['U', 'C', 'P', 'C']
find_idx = 0

for t in text:
  if find[find_idx] == t:
    find_idx += 1
    if find_idx == 4: break

print("I love UCPC") if find_idx == 4 else print("I hate UCPC")
