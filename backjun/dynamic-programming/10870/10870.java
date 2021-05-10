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
    int[] fib = new int[20+1];
    fib[0] = 0; fib[1] = 1;

    for(int i=2;i<=N;i++){
      fib[i] = fib[i-1]+fib[i-2];
    }
    
    bw.write(""+fib[N]+"\n");
    bw.flush();
  } 
}
