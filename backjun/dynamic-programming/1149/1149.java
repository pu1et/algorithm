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
    int[][] rgb = new int[1000+1][3];
    int[][] dp = new int[1000+1][3];
    int r,g,b;

    for(int i=1;i<=N;i++){
      String[] tmp = br.readLine().split(" ");
      rgb[i][0] = Integer.parseInt(tmp[0]);
      rgb[i][1] = Integer.parseInt(tmp[1]);
      rgb[i][2] = Integer.parseInt(tmp[2]);
    }

    for(int i=1;i<=N;i++){
      r = dp[i-1][0]; g = dp[i-1][1]; b = dp[i-1][2];
      if(g<=b) dp[i][0] = rgb[i][0] + g;
      else dp[i][0] = rgb[i][0] + b;
      
      if(r<=b) dp[i][1] = rgb[i][1] + r;
      else dp[i][1] = rgb[i][1] + b;

      if(r<=g) dp[i][2] = rgb[i][2] + r;
      else dp[i][2] = rgb[i][2] + g;
    }

    int min = dp[N][0];
    for(int i=1;i<=2;i++){
      if(dp[N][i]<min) min = dp[N][i];
    }
    
    bw.write(""+min+"\n");
    bw.flush();
  } 
}
