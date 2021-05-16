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

    int N = Integer.parseInt(br.readLine());
    int[] num = new int[11];
    num[0] = 0; num[1] = 1; num[2] = 2; num[3] = 4;
    int M;

    for(int i=4;i<=10;i++){
      num[i] = num[i-3]+num[i-2]+num[i-1];
    }

    for(int i=0;i<N;i++){
      M = Integer.parseInt(br.readLine());
      bw.write(""+num[M]+"\n");
    }
    bw.flush();
  } 
}
