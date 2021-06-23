import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    PriorityQueue<Long> card = new PriorityQueue<>();

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
    
    str = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      card.offer(Long.parseLong(str[i]));
    }

    for(int i=0;i<M;i++){
      long card1 = card.poll(), card2 = card.poll();
      long new_card = card1 + card2;
      card.offer(new_card);
      card.offer(new_card);
    }
    
    long sum = 0;
    for(int i=0;i<N;i++){
      sum += card.poll();
    }
    bw.write(sum+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
