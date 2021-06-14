import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
돈을 인출할 때 걸리는 시간이 이전 사람의 시간들의 누적값이 더해지므로
오름차순으로 정렬하여 각 인출시간을 더해주면 최소값이 된다.

1. 인출 시간을 오름차순 정렬한다.
2. 각 인출 시간을 더한다.
*/
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
    
    // 인출 시간 오름차순 정렬
    Arrays.sort(num); 
    int sum = 0, block=0;
    
    // 각 인출 시간을 더함
    for(int i:num){ 
      sum += (block+i);
      block +=i;
    }
    System.out.println(sum);
  }
}
