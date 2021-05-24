import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N;
  static int[][] graph;
  static int[] visited;

  static void dfs(int v){
    visited[v] = 1;
    for(int i=1;i<=N;i++){
      if(graph[v][i] == 1 && visited[i] == 0)
        dfs(i);
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    int M = Integer.parseInt(tmp[1]);
    int cnt = 0;

    graph = new int[N+1][N+1];
    visited = new int[N+1];

    for(int i=0;i<M;i++){
      tmp = br.readLine().split(" ");
      int row = Integer.parseInt(tmp[0]), col = Integer.parseInt(tmp[1]);
      graph[row][col] = 1; graph[col][row] = 1;
    }

    for(int i=1;i<=N;i++){
      if(visited[i] == 0){
        ++cnt;
        dfs(i);
      }
    }

    bw.write(cnt+"\n");
    bw.flush();
  } 
}
