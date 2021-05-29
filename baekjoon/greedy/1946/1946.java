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
    int M, result;
    int[][] sample;
    String[] tmp;

    for(int i=0;i<N;i++){
      M = Integer.parseInt(br.readLine());
      sample = new int[M][2];
      result = M;
      
      for (int j=0;j<M;j++){
        tmp = br.readLine().split(" ");
        sample[j][0] = Integer.parseInt(tmp[0]);
        sample[j][1] = Integer.parseInt(tmp[1]);
      }

      Arrays.sort(sample, new Comparator<int[]>(){
        @Override
        public int compare(int[] t1, int[] t2){ 
          return t1[0]-t2[0];
        }
      });
      int comp = sample[0][1];
      for(int j=1;j<M;j++){
        if(comp>sample[j][1]) comp = sample[j][1];
        else result -= 1;
      }
      bw.write(""+result+"\n");
      bw.flush();
    }
  }
}
