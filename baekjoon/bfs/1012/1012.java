import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static Queue<rc> queue;
  static int[][] graph;
  static int M,N;

  static class rc{
    int r,c;
    public rc(int r, int c){
      this.r = r;
      this.c = c;
    }
  }

  public static int bfs() {
    int row, col, r, c, house = 0;
    int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};

    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(graph[i][j] == 1){
          ++house;
          queue = new LinkedList<rc>();
          queue.offer(new rc(i,j));
          graph[i][j] = 0;
          while(!queue.isEmpty()){
            row = queue.peek().r; col = queue.peek().c;
            queue.poll();
            for(int k=0;k<4;k++){
              r = row+p_r[k]; c = col+p_c[k];
              if((r>=0 && r<N) && (c>=0 && c<M) && graph[r][c] == 1){
                queue.offer(new rc(r,c));
                graph[r][c] = 0;
              }
            }
          }
        }
      }
    }
    return house;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int test_num = Integer.parseInt(br.readLine());
    String[] tmp;
    int cnt, col, row;

    for(int i=0;i<test_num;i++){
      tmp = br.readLine().split(" ");
      M = Integer.parseInt(tmp[0]);
      N = Integer.parseInt(tmp[1]);
      cnt = Integer.parseInt(tmp[2]);
      graph = new int[N][M];

      for(int j=0;j<cnt;j++){
        tmp = br.readLine().split(" ");
        col = Integer.parseInt(tmp[0]);
        row = Integer.parseInt(tmp[1]);
        graph[row][col] = 1;
      }

      System.out.println(bfs());
    }
  } 
}
