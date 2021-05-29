import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/*
1. K를 동전의 높은 가치의 개수부터 더함
2. 높은 가치를 나눈 몫을 빼주며 K 업데이트
*/
public class Main{

  public static void main(String []args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]), K = Integer.parseInt(str[1]);
    int[] money = new int[N];

    for(int i=0;i<N;i++){
      money[i] = Integer.parseInt(br.readLine());
    }
    
    int result = 0;
    for(int i=N-1;i>=0;i--){ // 높은 가치의 개수부터 낮은 가치 순으로
      result += K/money[i]; // 해당 가치의 개수
      K%=money[i]; // K 업데이트
      if(K==0) break;
    }
    
    bw.write(""+result);
    bw.flush();
  }
}
