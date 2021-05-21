import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int N;
  static int[][] graph;
  static int[] p_r = {1,0,-1,0}, p_c = {0,1,0,-1};
  static ArrayList<Integer> house = new ArrayList<>();

  static void dfs(int row, int col, int idx){
    graph[row][col] = 0;
    house.set(idx,house.get(idx)+1);
    for(int i=0;i<4;i++){
      int r = row+p_r[i], c = col+p_c[i];
      if((1<=r && r<=N) && (1<=c && c<=N) && (graph[r][c] == 1)){
        dfs(r,c,idx);
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N = Integer.parseInt(br.readLine());
    graph = new int[N+1][N+1];

    for(int i=1;i<=N;i++){
      String[] tmp = br.readLine().split("");
      for(int j=1;j<=N;j++){
        graph[i][j] = Integer.parseInt(tmp[j-1]);
      }
    }

    for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
        if(graph[i][j]==1){
          house.add(0);
          dfs(i,j,house.size()-1);
        }
      }
    }

    System.out.println(house.size());
    house.stream().sorted().forEach(a -> System.out.println(a));
  } 
}
