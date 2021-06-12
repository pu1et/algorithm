import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
1과 0중 연속된 수를 바꿔야 하는 횟수가 더 적은 숫자를 뒤집으면 된다.

1. [0 연속 횟수, 1 연속 횟수] 배열을 생성한다.
2. 둘 중 더 작은 값을 출력한다.
*/

public class Main{
  
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split("");
    int[] arr = {0,0};
    int flag = Integer.parseInt(tmp[0]);
    ++arr[flag];

    // {0 연속 횟수, 1 연속 횟수} 배열 생성
    for(int i=1;i<tmp.length;i++){
      int comp = Integer.parseInt(tmp[i]);
      if(flag != comp){
        flag = comp;
        ++arr[flag]; 
      }
    }
    // 둘 중 더 작은 값 출력
    System.out.println(Math.min(arr[0],arr[1]));
  } 
}
