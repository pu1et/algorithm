import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int[] visited;
  static int start,end;

  public static int bfs() {
    Queue<Integer> queue = new LinkedList<Integer>();
    int pop;
    queue.offer(start);
    visited[start] = 0;
    while(true){
      pop = queue.poll();
      if(pop == end) return visited[pop];
      if(pop+1 <= 100000 && visited[pop+1] == 0){
        queue.offer(pop+1);
        visited[pop+1] = visited[pop] + 1;
      }
      if(pop-1 >= 0 && visited[pop-1] == 0){
        queue.offer(pop-1);
        visited[pop-1] = visited[pop] + 1;
      }
      if(pop*2 <= 100000 && visited[pop*2] == 0){
        queue.offer(pop*2);
        visited[pop*2] = visited[pop] + 1;
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    start = Integer.parseInt(tmp[0]);
    end = Integer.parseInt(tmp[1]);

    visited = new int[100000+1];
    System.out.println(bfs());
  } 
}
