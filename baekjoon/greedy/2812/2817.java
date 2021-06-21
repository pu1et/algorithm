import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static class NI implements Comparable<NI>{
    int num, idx;
    NI(int num, int idx){
      this.num = num;
      this.idx = idx;
    }
    @Override
    public int compareTo(NI target){
      if(this.num == target.num){
        if(this.idx < target.idx) return 1;
        else return 0;
      }
      else return this.num - target.num;

    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    PriorityQueue<NI> pq = new PriorityQueue<NI>(Collections.reverseOrder()); 

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]), K = Integer.parseInt(str[1]); K = N-K;
    int[] tmp = new int[N];

    str = br.readLine().split("");
    for(int i=0;i<N;i++){
      tmp[i] = Integer.parseInt(str[i]);
    }

    for(int i=0;i<=N-K;i++){
      pq.offer(new NI(tmp[i],i));
    }
    
    int num = pq.peek().num, last_idx = pq.poll().idx;
    bw.write(num+"");

    for(int i=N-K+1;i<N;i++){
      pq.offer(new NI(tmp[i],i));
      while(true){
        num = pq.peek().num; int idx = pq.poll().idx;
        if(last_idx < idx){
          last_idx = idx;
          break;
        }
      }
      bw.write(num+"");
    }
    
    bw.flush();
    bw.close();
    br.close();
  } 
}
