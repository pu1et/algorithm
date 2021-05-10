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
    int[] seq = new int[1000+1], dp = new int[1000+1];
    
    String[] tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      seq[i] = Integer.parseInt(tmp[i]);
    }
    Arrays.fill(dp,1);

    for(int i=0;i<N;i++){
      for(int j=0;j<i;j++){
        if(seq[i]>seq[j] && dp[i]<(dp[j]+1)) dp[i] = dp[j]+1;
      }
    }

    int max = dp[0];
    for(int i=1;i<N;i++){
      if(max<dp[i]) max = dp[i];
    }
    bw.write(""+max+"\n");
    bw.flush();
  } 
}
