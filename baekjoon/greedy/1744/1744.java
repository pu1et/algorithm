import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
최대값을 만들려면 양수는 양수끼리, 음수는 음수끼리 곱해서 더하면 된다.
예외 1) 0은 음수에 곱해주면 도움이 되므로 음수쪽에 넣어준다.
예외 2) 1은 어느 곳에 곱해도 그대로 값이 나오므로 그냥 더해준다.

1. 양수(>0)와  양수가 아닌 수(<=0)를 나눠서 저장한다. 단, 1은 더한다(양수, 음수 계산에 도움이 안되기 때문)
2. 양수 배열은 내림차순, 양수가 아닌 수 배열은 오름차순 정렬한다.(- * -는 +이기 때문) => 우선순위 큐 사용
3. 차례대로 2개씩 꺼내서 각각 결과값에 더한다.
*/

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

    // 양수(>0)와  양수가 아닌 수(<=0)를 나눠서 저장하고, 1은 더함
    for(int i=0;i<N;i++){
      int tmp = Integer.parseInt(br.readLine());
      if(tmp == 1) ++result;
      else if(tmp > 0) plus.offer(tmp);
      else minus.offer(tmp);
    }

    // 양수를 저장한 우선순위 큐에서 2개씩 꺼내면서 결과값에 더함
    int size = plus.size();
    for(int i=0;i<size/2;i++){
      result += plus.poll() * plus.poll();
    }
    if(plus.size() > 0) result += plus.poll();

    // 양수가 아닌 수를 저장한 우선순위 큐에서 2개씩 꺼내면서 결과값에 더함
    size = minus.size();
    for(int i=0;i<size/2;i++){
      result += minus.poll() * minus.poll();
    }
    if(minus.size() > 0) result += minus.poll();

    System.out.println(result);
  } 
}
