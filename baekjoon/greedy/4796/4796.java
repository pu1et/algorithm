import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = 0;
    while(true){
      String[] tmp = br.readLine().split(" ");
      int L = Integer.parseInt(tmp[0]);
      int P = Integer.parseInt(tmp[1]);
      int V = Integer.parseInt(tmp[2]);

      if(L+P+V == 0) break;
      System.out.printf("Case %d: %d\n", ++cnt, V/P*L + Math.min(V%P,L));
    }
  } 
}
