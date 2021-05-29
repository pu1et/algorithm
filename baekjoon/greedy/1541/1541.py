'''
결과값이 최소여야하므로 -를 기준으로 문자열을 나누어 각 부분값을 빼주면 된다.
ex) 55-50+40-70 -> 55-(55+40)-70

1. -를 기준으로 문자열을 분리한다.
  ex) 55, 55+40, 70
2. 각 수를 더해준다. (+ 가 존재하면 더함)
  ex) 55, 95, 70
3. 뺀다.
  ex) -55-95-70 = -220
'''

N = input().split("-")
result = 0
for i in range(0,len(N)):
  tmp_cal = 0
  for j in (N[i].split("+")):
    tmp_cal += int(j)
  if(i==0): result = tmp_cal
  else: result -= tmp_cal

print(result)
