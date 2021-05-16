import sys

dwarf = []
for i in range(9):
  dwarf.append(int(sys.stdin.readline()))
dwarf.sort()
flag = 0
for i in range(3):
  for j in range(i+1,4):
    for k in range(j+1,5):
      for l in range(k+1,6):
        for m in range(l+1,7):
          for n in range(m+1,8):
            for o in range(n+1,9):
              if((dwarf[i]+dwarf[j]+dwarf[k]+dwarf[l]+dwarf[m]+dwarf[n]+dwarf[o])==100):
                print("{}\n{}\n{}\n{}\n{}\n{}\n{}".format(dwarf[i],dwarf[j],dwarf[k],dwarf[l],dwarf[m],dwarf[n],dwarf[o]))
                flag = 1
                break
            if(flag == 1): break
          if(flag == 1): break  
        if(flag == 1): break
      if(flag == 1): break
    if(flag == 1): break
  if(flag == 1): break        

