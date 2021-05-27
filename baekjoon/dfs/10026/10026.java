import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N;
  static int[][] graph, graph_rgb, visited;
  static int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};

  static void dfs(int row, int col, int val){
    visited[row][col] = 1;
    for(int i=0;i<4;i++){
      int r= row+p_r[i], c = col+p_c[i];
      if((0<=r && r<N) && (0<=c && c<N) && visited[r][c] == 0 && graph[r][c] == val){
        dfs(r,c,val);
      }
    }
  }

  static void dfs_rgb(int row, int col, int val){
    visited[row][col] = 0;
    for(int i=0;i<4;i++){
      int r= row+p_r[i], c = col+p_c[i];
      if((0<=r && r<N) && (0<=c && c<N) && visited[r][c] == 1 && graph_rgb[r][c] == val){
        dfs_rgb(r,c,val);
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String tmp;
    N = Integer.parseInt(br.readLine());
    graph = new int[N][N]; 
    graph_rgb = new int[N][N];
    visited = new int[N][N];
    int[] result = {0,0};

    for(int i=0;i<N;i++){
      tmp = br.readLine();
      for(int j=0;j<N;j++){
        graph[i][j] = tmp.charAt(j);
        graph_rgb[i][j] = graph[i][j];
        if(graph_rgb[i][j] == 'G') graph_rgb[i][j] = 'R';
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(visited[i][j] == 0){
          ++result[0];
          dfs(i,j,graph[i][j]);
        }
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(visited[i][j] == 1){
          ++result[1];
          dfs_rgb(i,j,graph_rgb[i][j]);
        }
      }
    }


    bw.write(result[0]+" "+result[1]);
    bw.flush();
  } 
}
