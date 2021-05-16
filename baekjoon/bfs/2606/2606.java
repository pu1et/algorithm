import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
  static int[][] graph;
  static int[] visited;
  static int N,cnt=0;

  public static void bfs() {
    Queue<Integer> queue = new LinkedList<Integer>();
    int pop;
    queue.offer(1);
    visited[1] = 1;
    while(!queue.isEmpty()){
      pop = queue.poll();
      for(int i=1;i<=N;i++){
        if(graph[pop][i] == 1 && visited[i] == 0){
          queue.offer(i);
          visited[i] = 1;
          ++cnt;
        }
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp;
    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    graph = new int[N+1][N+1];
    visited = new int[N+1];

    for(int i=0;i<M;i++){
      tmp = br.readLine().split(" ");
      int row,col;
      for(int j=0;j<N;j++){
        row = Integer.parseInt(tmp[0]);
        col = Integer.parseInt(tmp[1]);
        graph[row][col] = 1; graph[col][row] = 1;
      }
    }
    bfs();

    System.out.println(cnt);
  } 
}
