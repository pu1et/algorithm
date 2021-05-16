import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); // N
    int result = N,tmp,diff;
    String[] str;

    for(int i=100;i<=N;i++){
      str = (""+i).split("");
      diff = Integer.parseInt(str[0]) - Integer.parseInt(str[1]);
      for (int j=1;j<str.length-1;j++){
        tmp = Integer.parseInt(str[j]) - Integer.parseInt(str[j+1]);
        if(tmp != diff){
          result -= 1;
          break;
        }
      }
    }

    bw.write(""+result);
    bw.flush();
  }
}
