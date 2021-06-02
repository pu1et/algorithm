import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
  static int[][] origin;

  public static void change(int row, int col){
    for(int i=row;i<row+3;i++){
      for(int j=col;j<col+3;j++){
        if(origin[i][j] == 1) origin[i][j] = 0;
        else origin[i][j] = 1;
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minus = new PriorityQueue<>();

    int N = Integer.parseInt(br.readLine());
    int result = 0;

    for(int i=0;i<N;i++){
      int tmp = Integer.parseInt(br.readLine());
      if(tmp == 1) ++result;
      else if(tmp > 0) plus.offer(tmp);
      else minus.offer(tmp);
    }

    int size = plus.size();
    for(int i=0;i<size/2;i++){
      result += plus.poll() * plus.poll();
    }
    if(plus.size() > 0) result += plus.poll();

    size = minus.size();
    for(int i=0;i<size/2;i++){
      result += minus.poll() * minus.poll();
    }
    if(minus.size() > 0) result += minus.poll();

    System.out.println(result);
  } 
}
