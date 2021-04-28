import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); // N
    int max = -1, tmp;
    int[] rope = new int[N];
    for (int i=0;i<N;i++){
      rope[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(rope);

    for(int i=0;i<N;i++){
      tmp = rope[i]*(N-i);
      if(tmp>max) max = tmp;
    }
    bw.write(""+max);
    bw.flush();
  }
}
