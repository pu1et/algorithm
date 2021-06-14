import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
제일 낮은 위치부터 테이프를 붙여간다.
  
1. 물이 새는 위치를 오름차순 정렬한다.
2. 제일 낮은 위치부터 시작하여 테이프 수를 +1씩 해주고
   테이프의 길이만큼 위치를 증가시킨다. 
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    int N = Integer.parseInt(tmp[0]), L = Integer.parseInt(tmp[1]);
    int[] thing = new int[N];

    tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      thing[i] = Integer.parseInt(tmp[i]);
    }
    // 물이 새는 위치 오름차순 정렬
    Arrays.sort(thing);

    int result = 0;
    int idx = 0;

    // 제일 낮은 위치부터 테이프를 붙여감
    for(int t: thing){
      if(idx < t){
        ++result;
        idx = t + L - 1;
      }
    }

    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
