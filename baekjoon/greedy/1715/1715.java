import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
합친 카드의 수만큼 계속 더해지기 때문에 수가 적은 카드 묶음부터 차례대로 카드를 섞는다.

1. 카드 묶음을 최소 힙(우선순위 큐)에 넣는다.
2. 힙에서 가장 수가 적은 카드 묶음 2개를 꺼내 합친다.
3. 합한 카드 묶음을 최소 힙(우선순위 큐)에 넣어준다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // 카드 묶음을 우선순위 큐에 넣음
    for(int i=0;i<N;i++){
        pq.offer(Integer.parseInt(br.readLine()));
    }

    if(N == 1) System.out.println(0);
    else{
      int result = 0;
      while(pq.size()>1){
        // 힙에서 가장 수가 적은 카드 묶음 2개를 꺼내 합침
        int tmp1 = pq.poll(), tmp2 = pq.poll();
        result += tmp1 + tmp2;
        
        // 합한 카드 묶음을 우선순위 큐에 넣음
        pq.offer(tmp1+tmp2);
      }
      System.out.println(result);
    }
  } 
}
