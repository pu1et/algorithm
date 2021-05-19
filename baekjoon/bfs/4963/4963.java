import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N,M,result;
  static int[][] graph;
  static int[] p_r = {1,0,-1,0,1,1,-1,-1}, p_c = {0,1,0,-1,1,-1,1,-1};

  static class rc{
    int r,c;
    rc(int r, int c){
      this.r = r;
      this.c = c;
    }
  }

  static int bfs(){
    int cnt = 0;
    Queue<rc> queue = new LinkedList<rc>();
    for(int i=1;i<=N;i++){
      for(int j=1;j<=M;j++){
        if(graph[i][j] == 1){
          queue.offer(new rc(i,j));
          graph[i][j] = 0;
          ++cnt;
          while(!queue.isEmpty()){
            int row = queue.peek().r, col = queue.poll().c;
            for(int k=0;k<8;k++){
              int r = row+p_r[k], c = col+p_c[k];
              if((r>=1 && r<=N) && (c>=1 && c<=M) && graph[r][c]==1){
                queue.offer(new rc(r,c));
                graph[r][c] = 0;
              }
            }
          }
        }
      }
    }
    return cnt;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true){
      String[] tmp = br.readLine().split(" ");
      M = Integer.parseInt(tmp[0]);
      N = Integer.parseInt(tmp[1]);
      if(N==0 && M==0) break;
      else{
        graph = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
          tmp = br.readLine().split(" ");
          for(int j=1;j<=M;j++){
            graph[i][j] = Integer.parseInt(tmp[j-1]);
          }
        }
        System.out.println(bfs());
      }
    }
  } 
}
