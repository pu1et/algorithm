import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
  static int[][] graph;
  static int[] visited;
  static int N;
  static BufferedWriter bw;

  public static void dfs(int v) throws Exception{
    visited[v] = 1;
    bw.write(v+" ");
    for(int i=1;i<=N;i++){
      if(visited[i] == 0 && graph[v][i] == 1)
        dfs(i);
    }
  }

  public static void bfs(int v) throws Exception{
    visited[v] = 1;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(v);
    int pop;

    while(!queue.isEmpty()){
      pop = queue.poll();
      bw.write(pop+" ");
      for(int i=1;i<=N;i++){
        if(visited[i]==0 && graph[pop][i]==1){
          queue.offer(i);
          visited[i] = 1;
        }
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    int M = Integer.parseInt(tmp[1]);
    int V = Integer.parseInt(tmp[2]);
    graph = new int[N+1][N+1];

    int n1, n2;
    for(int i=0;i<M;i++){
      tmp = br.readLine().split(" ");
      n1 = Integer.parseInt(tmp[0]);
      n2 = Integer.parseInt(tmp[1]);
      graph[n1][n2] = 1;
      graph[n2][n1] = 1;  
    }
    visited = new int[N+1];
    dfs(V);

    bw.write("\n");
    visited = new int[N+1];
    bfs(V);
    bw.flush();
  } 
}
