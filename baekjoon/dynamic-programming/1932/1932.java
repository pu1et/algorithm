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
    int[] tree = new int[(int)N*(N+1)/2+1];
    int[] dp = new int[(int)N*(N+1)/2+1];
    int idx = 1,max;

    for(int i=1;i<=N;i++){
      String[] tmp = br.readLine().split(" ");
      for(int j=0;j<tmp.length;j++){
        tree[idx++] = Integer.parseInt(tmp[j]);
      }
    }

    if(N == 1) bw.write(""+tree[1]+"\n");
    else{
      dp[1] = tree[1];
      for(int i=1;i<N;i++){
        idx = (int)i*(i+1)/2+1;
        for(int j=idx;j<=idx+i;j++){
          if(j==idx) dp[j] = dp[j-i] + tree[j];
          else if(j==idx+i) dp[j] = dp[j-(i+1)] + tree[j];
          else{
            if(dp[j-(i+1)] >= dp[j-i]) dp[j] = dp[j-(i+1)] + tree[j];
            else dp[j] = dp[j-i] + tree[j];
          }
        }
      }

      idx = (int)N*(N-1)/2+1;
      max = dp[idx];
      for(int i=idx+1;i<idx+N;i++){
        if(max<dp[i]) max = dp[i];
      }
      bw.write(""+max+"\n");
    }
    bw.flush();
  } 
}
