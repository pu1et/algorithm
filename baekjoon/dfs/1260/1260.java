import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N;
  static int[][] graph;
  static int[] visited;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void bfs(int v) throws Exception{
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(v);
    visited[v] = 0;
    while(!queue.isEmpty()){
      int pop = queue.poll();
      bw.write(pop+" ");
      for(int i=1;i<=N;i++){
        if(graph[pop][i] == 1 && visited[i] == 1){
          queue.offer(i);
          visited[i] = 0;
        }
      }
    }
  }

  static void dfs(int v) throws Exception{
    visited[v] = 1;
    bw.write(v+" ");
    for(int i=1;i<=N;i++){
      if(graph[v][i] == 1 && visited[i] == 0) dfs(i);
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    int M = Integer.parseInt(tmp[1]);
    int V = Integer.parseInt(tmp[2]);

    graph = new int[N+1][N+1];
    visited = new int[N+1];

    for(int i=0;i<M;i++){
      tmp = br.readLine().split(" ");
      int v1 = Integer.parseInt(tmp[0]), v2 = Integer.parseInt(tmp[1]);
      graph[v1][v2] = 1;
      graph[v2][v1] = 1;
    }

    dfs(V);
    bw.write("\n");
    bfs(V);
    bw.flush();
  } 
}
