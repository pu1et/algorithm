import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] num = new int[(int)Math.pow(10,6)+1];
    int[] tmp = new int[3];
    int min;

    num[0] = 0; num[1] = 0; num[2] = 1; num[3] = 1;
    for(int i=4;i<=N;i++){
      Arrays.fill(tmp,0);
      tmp[0] = num[i-1]+1;
      if(i%2==0) tmp[1] = num[i/2]+1;
      if(i%3==0) tmp[2] = num[i/3]+1;

      min = tmp[0];
      for(int j=1;j<3;j++){
        if(tmp[j]!=0 && min>tmp[j]) min = tmp[j];
      }
      num[i] = min;
    }
    
    bw.write(""+num[N]+"\n");
    bw.flush();
  } 
}
