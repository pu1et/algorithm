import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
서로 다른 N개이기 때문에 공차가 1인 수열을 적용한다.
수열의 마지막 항은 (원래 값 + (200 - 수열의 합)) 으로 해주면 가장 높은 N개가 나온다.
ex) 200 => 1, 2, 3, ..., 17, 18, 19+(200-수열의 합(190))

1. 공차가 1인 수열의 합이 S보다 작거나 같게 될 때까지 인덱스를 증가시키고, 마지막 항의 인덱스를 출력한다.
ex) 200 -> 19*20/2 = 190
*/
public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    long N = Long.parseLong(br.readLine());
    long result = 0;
    
    // 수열의 총합 <= S 구하기
    while(++result*(result+1)/2 <= N){}
    System.out.println(result-1);
  } 
}
