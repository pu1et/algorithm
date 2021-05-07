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
    int[] block = new int[1000+1];

    block[0] = 0; block[1] = 1; block[2] = 2;
    for(int i=3;i<=N;i++){
      block[i] = (block[i-2]+block[i-1])%10007;
    }

    bw.write(""+block[N]+"\n");
    bw.flush();
  } 
}
