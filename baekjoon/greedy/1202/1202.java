import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    for(int i=0;i<N;i++){
      tmp = br.readLine().split(" ");
      jewels.offer(new Jewel(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])));
    }

    for(int i=0;i<M;i++){
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(bags);
    long result = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int bag: bags){
      while(!jewels.isEmpty() && (bag >= jewels.peek().weight)){
        pq.offer(-jewels.poll().price);
      }
      if(pq.size() > 0){
        result -= pq.poll();
      }
    }

    System.out.println(result);
  } 
}
