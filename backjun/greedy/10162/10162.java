import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine()); // N
    StringBuilder result = new StringBuilder();
    int[] time = {300,60,10};

    for(int i:time){
      result.append(T/i+" ");
      T%=i;
    }
    if(T != 0) result = new StringBuilder("-1");
    bw.write(result.toString());
    bw.flush();
  }
}
