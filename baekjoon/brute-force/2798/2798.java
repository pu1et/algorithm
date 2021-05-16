import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(" "); // N
    int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
    int[] card = new int[N];
    int result = M, tmp;

    str = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      card[i] = Integer.parseInt(str[i]); // 5,6,7,8,9
    }
    for(int i=0;i<N-2;i++){
      for(int j=i+1;j<N-1;j++){
        for(int k=j+1;k<N;k++){
          tmp = M-(card[i]+card[j]+card[k]);
          if( tmp >= 0 && result > tmp) result = tmp;
        }
      }
    }

    bw.write(""+(M-result));
    bw.flush();
  }
}
