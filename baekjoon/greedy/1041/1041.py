import sys

N = int(sys.stdin.readline())
dice = list(map(int,sys.stdin.readline().split()))
if N == 1: print(sum(dice) - max(dice))
else:
  min_dice = [min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3])]
  min_dice.sort()
    
  result = (N-2) * (5*N-6) * min_dice[0] # 1면
  result += (2*N-3) * 4 * (min_dice[0]+min_dice[1]) # 2면
  result += 4 * sum(min_dice) # 3면

  print(result)
