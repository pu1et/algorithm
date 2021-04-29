import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine());
    int result = 0,sum;

    for(int i=0;i<N;i++){
      sum = 0;
      for(String s: (""+i).split("")){
        sum += Integer.parseInt(s);
      }
      if(sum + i == N){
        result = i;
        break;
      }
    }
    

    bw.write(""+result);
    bw.flush();
  }
}
