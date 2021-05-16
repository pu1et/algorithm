N = input().split("-")
result = 0
for i in range(0,len(N)):
  tmp_cal = 0
  for j in (N[i].split("+")):
    tmp_cal += int(j)
  if(i==0): result = tmp_cal
  else: result -= tmp_cal

print(result)
