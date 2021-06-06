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

    int T = Integer.parseInt(br.readLine());
    for(int t=0;t<T;t++){
      int N = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());

      String[] tmp = br.readLine().split(" ");
      for(int i=0;i<N;i++){
        arr.offer(Integer.parseInt(tmp[i]));
      }
      
      int[] last = {arr.peek(), arr.poll()};
      int diff = 0;
      int for_len = 0;
      if(N%2==0) for_len = N/2 -1;
      else for_len = N/2;

      for(int i=0;i<for_len;i++){
        int[] pop = {arr.poll(), arr.poll()};
        diff = Collections.max(Arrays.asList(new Integer[]{diff, last[0]-pop[0], last[1]-pop[1]}));
        last[0] = pop[0]; last[1] = pop[1];
      }

      if(N%2==0){
        int pop = arr.poll();
        diff = Collections.max(Arrays.asList(new Integer[]{diff, last[0]-pop, last[1]-pop}));
      }

      bw.write(diff+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  } 
}
