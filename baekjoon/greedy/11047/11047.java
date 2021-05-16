import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{

  public static void main(String []args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]), K = Integer.parseInt(str[1]);
    int[] money = new int[N];

    for(int i=0;i<N;i++){
      money[i] = Integer.parseInt(br.readLine());
    }
    
    int result = 0;
    for(int i=N-1;i>=0;i--){
      result += K/money[i];
      K%=money[i];
      if(K==0) break;
    }
    
    bw.write(""+result);
    bw.flush();
  }
}
