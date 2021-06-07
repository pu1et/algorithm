import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");

    HashSet<Integer> hs = new HashSet<>();    
    for(int i=0;i<N;i++){
      hs.add(Integer.parseInt(str[i]));
    }
    N = hs.size();

    int[] spot = new int[N];
    Iterator<Integer> it = hs.iterator();
    for(int i=0;i<N;i++){
      spot[i] = it.next();
    }
    Arrays.sort(spot);

    int[] dist = new int[N];
    for(int i=1;i<N;i++){
      dist[i-1] = spot[i]-spot[i-1];
    }
    Arrays.sort(dist);

    if(K<=N){
      int sum = 0;
      for(int i=0;i<N-K+1;i++){
        sum += dist[i];
      }
      bw.write(sum+"\n");
    }else bw.write(0+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
