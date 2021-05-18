import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] visited;
  static int[][] graph;

  static int bfs(){
    int cnt = 0,pop;
    Queue<Integer> queue = new LinkedList<Integer>();
    for(int i=1;i<=N;i++){
      if(visited[i] == 0){
        queue.offer(i);
        visited[i] = 0;
        cnt += 1;
        while(!queue.isEmpty()){
          pop = queue.poll();
          for(int j=1;j<=N;j++){
            if(graph[pop][j] == 1 && visited[j]==0){
              queue.offer(j);
              visited[j] = 1;
            }
          }
        }
      }
    }
    return cnt;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    int M,row,col;
    N = Integer.parseInt(tmp[0]);
    M = Integer.parseInt(tmp[1]);
    graph = new int[N+1][N+1];
    visited = new int[N+1];

    for(int i=0;i<M;i++){
      tmp = br.readLine().split(" ");
      row = Integer.parseInt(tmp[0]);
      col = Integer.parseInt(tmp[1]);
      graph[row][col] = 1;
      graph[col][row] = 1;
    }

    System.out.println(bfs());
  } 
}
