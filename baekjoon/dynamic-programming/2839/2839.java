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
    int result = -1;
    int tmp;

    for(int i=0;i<=N/3;i++){
      tmp = N - 3*i;
      if(tmp %5 == 0){
        result = i + tmp/5;
        break;
      }
    }
    
    bw.write(""+result+"\n");
    bw.flush();
  } 
}
