import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
3의 몫을 0 ~ N//3 까지 늘려가며 N%3이 5의 배수면 
3과 5의 각 몫을 넣어주고 for문을 빠져나온다.
-> i값이 증가할수록 결과값이 커지므로
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int result = -1;
    int tmp;

    for(int i=0;i<=N/3;i++){
      tmp = N - 3*i; // == N%3
      if(tmp %5 == 0){
        result = i + tmp/5; // 최소 가방 수 이므로 break
        break;
      }
    }
    
    bw.write(""+result+"\n");
    bw.flush();
  } 
}
