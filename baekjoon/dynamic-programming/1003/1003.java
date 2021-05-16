import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine()),M;
    int[][]fib = new int[40+1][2];
    fib[0][0] = 1; fib[0][1] = 0; fib[1][0] = 0; fib[1][1] = 1;

    for(int i=2;i<=40;i++){
      fib[i][0] = fib[i-2][0] + fib[i-1][0];
      fib[i][1] = fib[i-2][1] + fib[i-1][1];
    }

    for(int i=0;i<N;i++){
      M = Integer.parseInt(br.readLine());
      bw.write(""+fib[M][0]+" "+fib[M][1]+"\n");
    }
    bw.flush();
  } 
}
