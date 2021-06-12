import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
"배열의 다음 숫자가 누적합+1 이하라면 누적합+1 까지 숫자들은 기존 숫자들의 조합으로 모두 표현 가능하다" 법칙을 사용한다.

1. 배열을 오름차순으로 정렬한다.
2. 반복문을 실행하면서, 배열의 값이 누적합 초과일 경우 반복문을 나온다.
3. 누적합을 출력한다.
*/

public class Main{
  static int[][] origin;

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    String[] tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(tmp[i]);
    }
    // 배열 오름차순 정렬
    Arrays.sort(arr);

    int num = 1;

    // 배열의 값이 누적합 초과일 경우 반복문을 나옴
    for(int i=0;i<N;i++){
      if(num >= arr[i]) num += arr[i];
      else break;
    }
    // 누적합 출력
    System.out.println(num);
  } 
}
