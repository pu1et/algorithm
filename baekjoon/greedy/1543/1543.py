import sys

doc = sys.stdin.readline().rstrip()
word = sys.stdin.readline().rstrip()
result = 0
idx = 0

while(idx <= len(doc)-len(word)):
  if doc[idx:idx+len(word)] == word: 
    result += 1
    idx += len(word)
  else: idx += 1

print(result)
