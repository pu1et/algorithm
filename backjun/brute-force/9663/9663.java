import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  static int N;
  static int result;
  static int[] arr;

  public static void solution(int x){
    if(x > N) {
      ++result;
      arr[x-1] = 0;
      return;
    }
    int flag;
    for(int i=1;i<N+1;i++){
      flag = 1;
      arr[x] = i;
      for(int j=1;j<x;j++){
        if(i==arr[j] || Math.abs(x-j) == Math.abs(i-arr[j])){
          flag = 0;
          break;
        }
      }
      if(flag == 1) solution(x+1);
      arr[x] = 0;
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N= Integer.parseInt(br.readLine());
    arr = new int[N+1];

    solution(1);

    bw.write(""+result);
    bw.flush();
  } 
}
