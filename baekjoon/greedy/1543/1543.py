import sys

'''
앞에서부터 맞는지 체크하면 된다.

1. 앞부터 1씩 인덱스를 증가하며 단어와 일치하는 지 체크한다.
2. 단어와 일치하면 인덱스를 단어의 길이만큼 증가해준다.
'''

doc = sys.stdin.readline().rstrip()
word = sys.stdin.readline().rstrip()
result = 0
idx = 0

while(idx <= len(doc)-len(word)):
  # 앞부터 1씩 인덱스를 증가하며 단어와 일치하는 지 체크
  if doc[idx:idx+len(word)] == word: 
    result += 1
    # 단어와 일치하면 단어의 길이만큼 인덱스 증가
    idx += len(word)
  else: idx += 1 # 일치하지 않으면 인덱스 증가

print(result)
