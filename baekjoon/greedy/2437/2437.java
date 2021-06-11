import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
  static int[][] origin;

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    String[] tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(tmp[i]);
    }
    Arrays.sort(arr);

    int num = 1;

    for(int i=0;i<N;i++){
      if(num >= arr[i]) num += arr[i];
      else break;
    }
    System.out.println(num);
  } 
}
