import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N,M;
  static int[][] graph;
  static int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};

  static void dfs(int row, int col){
    graph[row][col] = 0;
    for(int i=0;i<4;i++){
      int r = row+p_r[i], c = col+p_c[i];
      if((0<=r && r<N) && (0<=c && c<M) && graph[r][c] == 1)
        dfs(r,c);
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test = Integer.parseInt(br.readLine());
    for(int k=0;k<test;k++){
      String[] tmp = br.readLine().split(" ");
      M = Integer.parseInt(tmp[0]);
      N = Integer.parseInt(tmp[1]);
      int K = Integer.parseInt(tmp[2]);
      int house = 0;

      graph = new int[N][M];

      for(int i=0;i<K;i++){
        tmp = br.readLine().split(" ");
        int row = Integer.parseInt(tmp[1]), col = Integer.parseInt(tmp[0]);
        graph[row][col] = 1;
      }
      
      for(int i=0;i<N;i++){
        for (int j=0;j<M;j++){
          if(graph[i][j] == 1){
            house += 1;
            dfs(i,j);
          }
        }
      }

      bw.write(house+"\n");
    }
    bw.flush();
  } 
}
