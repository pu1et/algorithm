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
    
    int N = Integer.parseInt(br.readLine());
    int[][] conf = new int[N][2];
    String[] str;

    // 초기화
    for(int i=0;i<N;i++){
      str = br.readLine().split(" ");
      conf[i][0] = Integer.parseInt(str[0]);
      conf[i][1] = Integer.parseInt(str[1]);
    }

    Arrays.sort(conf, new Comparator<int[]>(){
      @Override
      public int compare(int[] o1, int[] o2){
        if(o1[1]==o2[1]) return o1[0]-o2[0];
        else return o1[1]-o2[1];
      }
    });
  
    int cnt=1, time=conf[0][1];
    for(int i=1;i<N;i++){
      if(conf[i][0] >= time){
        time=conf[i][1];
        cnt+=1;
      }
    }

    bw.write(""+cnt);
    bw.flush();
  }
}
