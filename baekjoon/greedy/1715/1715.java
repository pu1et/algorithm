import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i=0;i<N;i++){
        pq.offer(Integer.parseInt(br.readLine()));
    }

    if(N == 1) System.out.println(0);
    else{
      int result = 0;
      while(pq.size()>1){
        int tmp1 = pq.poll(), tmp2 = pq.poll();
        result += tmp1 + tmp2;
        pq.offer(tmp1+tmp2);
      }
      System.out.println(result);
    }
  } 
}
