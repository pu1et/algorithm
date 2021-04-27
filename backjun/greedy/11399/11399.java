import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

  public static void main(String []args) throws IOException{
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    int N = Integer.parseInt(br.readLine());
    String[] tmp = br.readLine().split(" ");
    int[] num = new int[N];
    
    for (int i=0;i<N;i++){
      num[i] = Integer.parseInt(tmp[i]);
    }
    
    Arrays.sort(num);
    int sum = 0, block=0;
    
    for(int i:num){
      sum += (block+i);
      block +=i;
    }
    System.out.println(sum);
  }
}
