import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static Queue<rc> queue;
  static int[][] tomato;
  static int M,N,ripe;

  static class rc{
    int r,c;
    public rc(int r, int c){
      this.r = r;
      this.c = c;
    }
  }

  public static int bfs() {
    int row, col, r, c;
    int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};


    while(!queue.isEmpty()){
      row = queue.peek().r; col = queue.peek().c;
      queue.poll();
      for(int i=0;i<4;i++){
        r = row+p_r[i]; c = col + p_c[i];
        if((r>=1 && r<=N) && (c>=1 && c<=M) && tomato[r][c]==0){
          queue.offer(new rc(r,c));
          tomato[r][c] = tomato[row][col] + 1;
          ripe -= 1;
        }
      }
      if(ripe == 0) return tomato[row][col];
    }
    return -1;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    M = Integer.parseInt(tmp[0]);
    N = Integer.parseInt(tmp[1]);
    queue = new LinkedList<rc>();

    tomato = new int[N+1][M+1];
    ripe = N*M;
    int row, col;
    for(int i=1;i<=N;i++){
      tmp = br.readLine().split(" ");
      for(int j=1;j<=M;j++){
        tomato[i][j] = Integer.parseInt(tmp[j-1]);
        if(tomato[i][j] == 1){
          queue.offer(new rc(i,j));
          ripe -=1;
        }else if(tomato[i][j] == -1){
          ripe -=1;
        }
      }
    }

    if(ripe == 0) System.out.println(0);
    else System.out.println(bfs());
  } 
}
