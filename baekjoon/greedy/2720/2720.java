import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] cent = {25, 10, 5, 1};

    for(int i=0;i<N;i++){
      int money = Integer.parseInt(br.readLine());
      int[] result = {0, 0, 0, 0};

      for(int j=0;j<4;j++){
        result[j] = money / cent[j];
        money %= cent[j]; 
        if(money == 0) break;
      }

      for(int j=0;j<4;j++){
        bw.write(result[j]+" ");
      }
      bw.write("\n");
      bw.flush();
    }

    bw.close();
    br.close();
  } 
}
