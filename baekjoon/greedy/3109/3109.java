import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int[][] graph;
  static int[] p_r = {-1,0,1};
  static int N, M;

  static int bt(int row, int col){
    if(col == M-1) return 1;
    else{
      int ret = 0;
      for(int i=0;i<3;i++){
        int r = row+p_r[i], c = col+1;
        if((r>=1 && r<=N) && c<=M && graph[r][c] == '.'){
          graph[r][c] = 'x';
          ret = bt(r,c);
          if(ret == 1) return 1;
        }
      }
      return 0;
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]); M = Integer.parseInt(tmp[1]);
    graph = new int[N+1][M+1];
    int cnt = 0;

    for(int i=1;i<=N;i++){
      String str = br.readLine();
      for(int j=1;j<=M;j++){
        graph[i][j] = str.charAt(j-1);
      }
    }
    for(int i=2;i<=N;i++){
      if(graph[i][2] == '.'){
    int ret = bt(i,2);
        if(ret == 1) cnt += 1;
      }
    }

    bw.write(cnt+"\n");

    bw.flush();
    bw.close();
    br.close();
