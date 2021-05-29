import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/*
빨리 끝나는 시간 기준으로 강의 개수를 더함

1. 끝나는 시간 -> 시작 시간 순으로 오름차순 정렬
2. 현재 시간과 같거나 이후 시간의 강의가 있는지 체크
3. 있다면 끝나는 시간을 현재 시간으로 업데이트

*/

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

    // 끝나는 시간 -> 시작 시간 강의 순으로 오름차순 정렬
    Arrays.sort(conf, new Comparator<int[]>(){
      @Override
      public int compare(int[] o1, int[] o2){
        if(o1[1]==o2[1]) return o1[0]-o2[0];
        else return o1[1]-o2[1];
      }
    });
  
    // cnt : 강의 개수, time : 현재 시간
    int cnt=1, time=conf[0][1];
    for(int i=1;i<N;i++){
      if(conf[i][0] >= time){ // 현재 시간 이후 시작한 강의라면
        time=conf[i][1]; // 현재 시간을 이 강의의 끝나는 시간으로 업데이트
        cnt+=1; // 강의 개수 
      }
    }

    bw.write(""+cnt);
    bw.flush();
  }
}
