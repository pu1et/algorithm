import java.util.*;
import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  static int N;
  static int flag = 0;
  static int result_min, result_max;
  static int[] op, num,arr;

  public static int calc(){
    int sum = num[0];
    for(int i=0;i<N-1;i++){
      if(op[arr[i]] == 0) sum += num[i+1];
      else if(op[arr[i]] == 1) sum -= num[i+1];
      else if(op[arr[i]] == 2) sum *= num[i+1];
      else{
        if (sum <0) sum = -1*(-1*sum/num[i+1]);
        else sum/=num[i+1];
      }
    }
    return sum;
  }

  public static void permutations(int idx){
    if(idx == N-1) {
      int tmp = calc();
      if(flag == 0) {result_min = tmp; result_max = tmp; flag = 1;}
      else{
        if(result_min>tmp) result_min = tmp;
        if(result_max<tmp) result_max = tmp;
      }
      arr[idx-1] = -1;
    }
    else{
      int sig = 1;
      for(int i=0;i<N-1;i++){
        sig = 1;
        for(int j=0;j<idx;j++){
          if(i==arr[j]) {
            sig = 0;
            break;
          }
        }
        if(sig == 1) {
          arr[idx] = i;
          permutations(idx+1);
        }
      }
      arr[idx] = -1;
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N= Integer.parseInt(br.readLine());
    num = new int[N];
    String[] tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      num[i] = Integer.parseInt(tmp[i]);
    }
    tmp = br.readLine().split(" ");
    op = new int[N-1];
    
    int x = 0;
    for(int i=0;i<4;i++){
      if(i==0){
        for(int j=0;j<Integer.parseInt(tmp[i]);j++)
          op[x++] = 0;
      }else if(i==1){
        for(int j=0;j<Integer.parseInt(tmp[i]);j++)
          op[x++] = 1;
      }else if(i==2){
        for(int j=0;j<Integer.parseInt(tmp[i]);j++)
          op[x++] = 2;
      }else if(i==3){
        for(int j=0;j<Integer.parseInt(tmp[i]);j++)
          op[x++] = 3;
      }
    }
    
    for(int i=0;i<N-1;i++){
      arr = new int[N-1];
      arr[0] = i;
      permutations(1);
    }

    bw.write(""+result_max+"\n"+result_min);
    bw.flush();
  } 
}
