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
    int[] seat = new int[N];

    String tmp = br.readLine();
    for(int i=0;i<N;i++){
      seat[i] = tmp.charAt(i);
    }
    
    int idx = 0, cnt = 0, flag = 0;
    while(idx<N){
      if(flag == 0){
        if(seat[idx] == 'S'){
          ++idx; ++cnt;
        }else{
          idx+=2; cnt+=2;
          flag = 1;
        }
      }else{
        if(seat[idx] == 'S'){
          ++idx; ++cnt;
        }else{
          idx+=2; ++cnt;
        }
      }
    }
    
    bw.write(cnt+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
