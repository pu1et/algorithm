import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
각 가방에 들어갈 수 있는 무게의 보석 중 가장 가격이 나가는 것을 넣으면 된다.  

1. 보석은 보석 무게 기준 오름차순 정렬, 가방은 가방에 담을 수 있는 무게 기준으로 오름차순 정렬한다.
2. 가방을 반복문으로 돌면서 현재 가방에 담을 수 있는 최대 무게보다 작은 무게를 가진 모든 보석을
   꺼내서 보석 가격을 기준으로 최대 힙에 넣는다.
3. 최대 힙에서 꺼낸 보석의 가격을 결과값에 더해준다.
*/

public class Main{
  static class Jewel implements Comparable<Jewel>{
    int weight, price;
    Jewel(int weight, int price){
      this.weight = weight;
      this.price = price;
    }

    @Override
    public int compareTo(Jewel target){
      return this.weight - target.weight;
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);
    PriorityQueue<Jewel> jewels = new PriorityQueue<Jewel>();
    int[] bags = new int[M];

    // 보석은 보석 무게를 기준으로 오름차순 정렬
    for(int i=0;i<N;i++){
      tmp = br.readLine().split(" ");
      jewels.offer(new Jewel(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])));
    }

    for(int i=0;i<M;i++){
      bags[i] = Integer.parseInt(br.readLine());
    }

    // 가방은 가방에 담을 수 있는 무게 기준으로 오름차순 정렬
    Arrays.sort(bags);
    long result = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int bag: bags){
      // 현재 가방에 담을 수 있는 최대 무게보다 작은 무게를 가진 모든 보석을 꺼내 보석 가격을 기준으로 최대 힙에 넣음
      while(!jewels.isEmpty() && (bag >= jewels.peek().weight)){
        pq.offer(-jewels.poll().price);
      }
      // 최대 힙에서 꺼낸 보석의 가격을 결과값에 더함
      if(pq.size() > 0){
        result -= pq.poll();
      }
    }

    System.out.println(result);
  } 
}
