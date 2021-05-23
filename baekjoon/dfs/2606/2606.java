import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
  static int N;
  static int[][] graph;
  static int[] visited;

  static int dfs(int v){
    visited[v] = 1;
    int cnt = 1;
    for(int i=1;i<=N;i++){
      if(graph[v][i] == 1 && visited[i] == 0){
        cnt += dfs(i);
      }
    }
    return cnt;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    graph = new int[N+1][N+1];
    visited = new int[N+1];

    for(int i=0;i<M;i++){
      String[] tmp = br.readLine().split(" ");
      int row = Integer.parseInt(tmp[0]), col = Integer.parseInt(tmp[1]);
      graph[row][col] = 1;
      graph[col][row] = 1;
    }

    System.out.println(dfs(1)-1);
  } 
}
