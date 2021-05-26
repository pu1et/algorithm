import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N,h;
  static int[][] copy_graph;
  static int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};

  static void dfs(int row, int col){
    copy_graph[row][col] = 0;
    for(int i=0;i<4;i++){
      int r = row+p_r[i], c = col+p_c[i];
      if((1<=r && r<=N)&&(1<=c && c<=N)&&copy_graph[r][c]>h)
        dfs(r,c);
    }
  }

  static void copy(int[][] graph, int[][] copy_graph){
    for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
        copy_graph[i][j] = graph[i][j];
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    int[][] graph = new int[N+1][N+1];
    copy_graph = new int[N+1][N+1];
    int max_h = 0;

    for(int i=1;i<=N;i++){
      String[] tmp = br.readLine().split(" ");
      for(int j=1;j<=N;j++){
        graph[i][j] = Integer.parseInt(tmp[j-1]);
        if(max_h < graph[i][j]) max_h = graph[i][j];
      }
    }
    int[] area = new int[max_h];

    for(h=0;h<max_h;h++){
      copy(graph, copy_graph);

      for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
          if(copy_graph[i][j]>h){
            ++area[h];
            dfs(i,j);
          }
        }
      }
    }

    int max_area = 0;
    for(int i=0;i<max_h;i++){
      if(max_area < area[i]) max_area = area[i];
    }
    bw.write(max_area+"\n");
    bw.flush();
  } 
}
