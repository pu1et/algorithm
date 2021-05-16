import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  static int N,M,result=-1,z_cnt=0,v_cnt=0;
  static int[] visited;
  static int[][] origin, zero, virus;

  public static void check(int[][] tmp, int row, int col){
    int[] p_r = {1,0,-1,0};
    int[] p_c = {0,1,0,-1};
    for(int i=0;i<4;i++){
      int c_r = row+p_r[i], c_c = col+p_c[i];
      if((c_r>=0 && c_r<N) && (c_c>=0 && c_c<M)){
        if(tmp[c_r][c_c]==0){
          tmp[c_r][c_c] = 2;
          check(tmp,c_r,c_c);
        }
      }
    }
  }

  public static void combination(int[] visited, int start, int n, int r){
    if(r==0){
      int[][]tmp = new int[N][M];
      for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
          tmp[i][j] = origin[i][j];
        }
      }

      for(int i=0;i<z_cnt;i++){
        if(visited[i]==1) tmp[zero[i][0]][zero[i][1]] = 1;
      }

      for(int i=0;i<v_cnt;i++){
        check(tmp, virus[i][0], virus[i][1]);
      }

      int t=0;
      for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
          if(tmp[i][j]==0) ++t;
        }
      }
      if(result == -1 || result<t) result = t;

    }else{
      for(int i=start;i<n;i++){
        visited[i] = 1;
        combination(visited,i+1,n,r-1);
        visited[i] = 0;
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    M = Integer.parseInt(tmp[1]);

    origin = new int[N][M];
    zero = new int[N*M][2];
    virus = new int[N*M][2];

    for(int i=0;i<N;i++){
      tmp = br.readLine().split(" ");
      for(int j=0;j<M;j++){
        origin[i][j] = Integer.parseInt(tmp[j]);
        if(origin[i][j]==0) {
          zero[z_cnt][0] = i;
          zero[z_cnt++][1] = j;
        }
        else if(origin[i][j]==2) {
          virus[v_cnt][0] = i;
          virus[v_cnt++][1] = j;
        }
      }
    }

    visited = new int[z_cnt];
    combination(visited,0,z_cnt,3);

    bw.write(""+result+"\n");
    bw.flush();
  } 
}
