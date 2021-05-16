import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class rc{
  int row;
  int col;
  public rc(int row, int col){
    this.row = row;
    this.col = col;
  }
}
public class Main {
  static int[][] graph;
  static int[][] visited;
  static int N,M;

  public static int bfs() {
    Queue<rc> queue = new LinkedList<rc>();
    queue.offer(new rc(1,1));
    visited[1][1] = 1;
    int result = 0;
    int row,col,p_r,p_c;
    int[] r = {1,0,-1,0}, c = {0,1,0,-1};

    while(!queue.isEmpty()){
      row = queue.peek().row; col = queue.peek().col;
      queue.poll();

      if(row == N && col == M){
        if(result == 0) result = visited[row][col];
        else{
          if(result > visited[row][col]) result = visited[row][col];
        }
      }else{
        for(int i=0;i<4;i++){
          p_r= row+r[i]; p_c = col+c[i];
          if((p_r >= 1 && p_r <= N) && (p_c >= 1 && p_c <= M)){
            if(visited[p_r][p_c] == 0 && graph[p_r][p_c] == 1){
              visited[p_r][p_c] = visited[row][col] + 1;
              queue.offer(new rc(p_r,p_c));
            }
          }
        }
      }
    }
    return result;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    M = Integer.parseInt(tmp[1]);
    graph = new int[N+1][M+1];
    visited = new int[N+1][M+1];

    for(int i=1;i<=N;i++){
      tmp = br.readLine().split("");
      for(int j=1;j<=M;j++){
        graph[i][j] = Integer.parseInt(tmp[j-1]);
      }
    }

    bw.write(""+bfs());
    bw.flush();
  } 
}
