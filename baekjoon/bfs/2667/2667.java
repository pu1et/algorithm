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
  static int N;
  static ArrayList<Integer> house = new ArrayList();

  public static void bfs() {
    int cnt, row, col, p_r, p_c;
    Queue<rc> queue = new LinkedList<rc>();
    int[] r = {1,0,-1,0}, c={0,1,0,-1};
    for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
        if(visited[i][j] == 0 && graph[i][j] ==1){
          cnt = 1;
          queue.offer(new rc(i,j));
          visited[i][j] = 1;
          while(!queue.isEmpty()){
            row = queue.peek().row;
            col = queue.peek().col;
            queue.poll();
            
            for(int k=0;k<4;k++){
              p_r = row + r[k]; p_c = col + c[k];
              if((p_r >= 1 && p_r <= N) && (p_c >=1 && p_c <= N)){
                if(visited[p_r][p_c] == 0 && graph[p_r][p_c] == 1){
                  queue.offer(new rc(p_r,p_c));
                  visited[p_r][p_c] = cnt + 1;
                  cnt += 1;
                }
              }
            }
          }
          house.add(cnt);
        }
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp;
    N = Integer.parseInt(br.readLine());

    graph = new int[N+1][N+1];
    visited = new int[N+1][N+1];

    for(int i=1;i<=N;i++){
      tmp = br.readLine().split("");
      for(int j=1;j<=N;j++){
        graph[i][j] = Integer.parseInt(tmp[j-1]);
      }
    }
    bfs();

    System.out.println(house.size());
    house.stream().sorted().forEach(System.out::println);
  } 
}
