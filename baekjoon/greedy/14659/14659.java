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
    String[] tmp = br.readLine().split(" ");
    int[] arrow = new int[N];
    int result = 0, cnt = 0, comp;

    for(int i=0;i<N;i++){
      arrow[i] = Integer.parseInt(tmp[i]);
    }

    comp = arrow[0];
    for(int i=1;i<N;i++){
      if(comp > arrow[i]) ++cnt;
      else{
        if(result < cnt) result = cnt;
        cnt = 0;
        comp = arrow[i];
      }
    }

    if(result < cnt) result = cnt;


    bw.write(""+result);    
    bw.flush();
    bw.close();
    br.close();
  } 
}
