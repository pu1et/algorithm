import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine());
    int[][] people = new int[N][2];
    String[] tmp;
    int[] result = new int[N];
    StringBuilder sb = new StringBuilder();

    Arrays.fill(result,1);
    for(int i=0;i<N;i++){
      tmp = br.readLine().split(" ");
      people[i][0] = Integer.parseInt(tmp[0]);
      people[i][1] = Integer.parseInt(tmp[1]);
    }


    for(int idx=0;idx<N;idx++){
      for(int i=0;i<N;i++){
        if((people[idx][0]<people[i][0]) && (people[idx][1]<people[i][1]))
          result[idx] += 1;
      }
    }

    for(int r: result)
      sb.append(r+" ");
    bw.write(sb.toString());
    bw.flush();
  } 
}
