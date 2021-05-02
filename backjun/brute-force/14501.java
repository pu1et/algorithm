import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  public static int[][] conf;
  public static int N;

  public static int solution(int start, int money){
    if(start==N){
      if (conf[start][0] == 1) return money + conf[start][1];
      else return money;
    }
    else if (start == N+1) return money;
    else if (start > N) return 0; 
    else {
      int a,b;
      a = solution(start+1,money);
      b = solution(start+conf[start][0],money+conf[start][1]);
      if(a>b) return a;
      else return b;
    }
  }
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N = Integer.parseInt(br.readLine());
    conf = new int[N+1][2];
    String[] tmp;

    for(int i=1;i<N+1;i++){
      tmp = br.readLine().split(" ");
      conf[i][0] = Integer.parseInt(tmp[0]);
      conf[i][1] = Integer.parseInt(tmp[1]);
    }
    bw.write(""+solution(1,0));
    bw.flush();
  } 
}
