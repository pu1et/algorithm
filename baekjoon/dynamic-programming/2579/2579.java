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
    int[] stair = new int[300+1];
    int[] dp = new int[300+1];
    int a,b;

    for(int i=1;i<=N;i++){
      stair[i] = Integer.parseInt(br.readLine());
    }

    if(N == 1) bw.write(""+stair[1]+"\n");
    else if(N == 2) bw.write(""+(stair[1]+stair[2])+"\n");
    else{
      dp[1] = stair[1]; dp[2] = stair[1]+stair[2];

      for(int i=3;i<=N;i++){
        a = dp[i-2] + stair[i];
        b = dp[i-3] + stair[i-1] + stair[i];
        if(a>=b) dp[i] = a;
        else dp[i] = b;
      } 
      bw.write(""+dp[N]+"\n");
    }
    bw.flush();
  } 
}
