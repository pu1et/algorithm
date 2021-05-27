import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N,M;
  static int[][] graph;
  static int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};

  static int dfs(int row, int col){
    graph[row][col] = 1;
    int ret = 1;
    for(int i=0;i<4;i++){
      int r= row+p_r[i], c = col+p_c[i];
      if((0<=r && r<N) && (0<=c && c<M) && graph[r][c] == 0){
        ret += dfs(r,c);
      }
    }
    return ret;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int cnt = Integer.parseInt(st.nextToken());
    graph = new int[N][M];

    for(int k=0;k<cnt;k++){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

      for(int i=y1;i<y2;i++){
        for(int j=x1;j<x2;j++){
          graph[i][j] = 1;
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<>();

    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(graph[i][j]==0){
          result.add(dfs(i,j));
        }
      }
    }

    bw.write(result.size()+"\n");
    Collections.sort(result);

    for(int i=0;i<result.size();i++){
      bw.write(result.get(i)+" ");
    }
    bw.flush();
  } 
}
