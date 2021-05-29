import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
최소 버튼 조작이므로 가장 오랜 시간 작동하는 버튼의 조작 개수부터 더해주면 된다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(br.readLine()); 
    StringBuilder result = new StringBuilder();
    int[] time = {300,60,10}; // 5분, 1분, 10초 단위 통일

    for(int i:time){
      result.append(T/i+" "); // 해당 버튼의 조작 개수 더함
      T%=i; // 남은 시간 
    }
    if(T != 0) result = new StringBuilder("-1");
    bw.write(result.toString());
    bw.flush();
  }
}
