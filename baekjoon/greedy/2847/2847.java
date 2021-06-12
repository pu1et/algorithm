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
    int[] arr = new int[N];
    int result = 0 ;
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    int tmp = arr[N-1];
    for(int i=N-2;i>=0;i--){
      if(tmp <= arr[i]){
        result += arr[i] - (tmp-1);
        tmp -= 1;
      }else tmp = arr[i];
    }
    
    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
