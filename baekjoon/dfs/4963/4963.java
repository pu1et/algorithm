import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N,M;
  static int[][] graph;
  static int[] p_r = {1,0,-1,0,1,1,-1,-1}, p_c = {0,1,0,-1,1,-1,1,-1};

  static void dfs(int row, int col){
    graph[row][col] = 0;
    for(int i=0;i<8;i++){
      int r = row+p_r[i], c = col+p_c[i];
      if((1<=r && r<=N) && (1<=c && c<=M) && graph[r][c]==1)
        dfs(r,c);
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true){
      String[] tmp = br.readLine().split(" ");
      M = Integer.parseInt(tmp[0]);
      N = Integer.parseInt(tmp[1]);
      int island = 0;
      if(N==0 && M==0) break;
      else{
        graph = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
          tmp = br.readLine().split(" ");
          for(int j=1;j<=M;j++){
            graph[i][j] = Integer.parseInt(tmp[j-1]);
          }
        }

        for(int i=1;i<=N;i++){
          for(int j=1;j<=M;j++){
            if(graph[i][j]==1){
              island +=1;
              dfs(i,j);
            }
          }
        }

        bw.write(island+"\n");
      }
    }
    bw.flush();
  } 
}
