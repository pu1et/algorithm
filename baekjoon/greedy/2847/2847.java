import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
마지막 레벨부터 첫번째 레벨로 반복문을 돌며 점수를 조절한다.

1. 이전 점수보다 크면, 
   점수 = 이전 레벨 점수 -1 (이전 레벨보단 점수가 낮아야됨)
   결과값 += 현재레벨점수 - 점수
2. 이전 점수보다 작으면, 점수 = 현재 레벨 점수
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int result = 0 ;
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    int tmp = arr[N-1];
    for(int i=N-2;i>=0;i--){
      // 이전 점수보다 크면, 점수 = 이전 레벨 점수 -1 (이전 레벨보단 점수가 낮아야됨)
      if(tmp <= arr[i]){
        result += arr[i] - (tmp-1);
        tmp -= 1;
      // 이전 점수보다 작으면, 점수 = 현재 레벨 점수
      }else tmp = arr[i];
    }
    
    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
