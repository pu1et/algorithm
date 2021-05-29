import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
각 로프가 버틸 수 있는 최대 중량은 가장 약한 중량의 로프부터 최대 중량을 계산하면 된다.
각 로프에 걸리는 중량인 w/k, 
로프 조합마다 최대 버틸 수 있는 w/k는 그 조합 중 (가장 약한 로프가 버틸 수 있는 중량) * (해당 경우의 로프 개수)이다.

2 3 4 5 6 10
2 * 6 = 12
3 * 5 = 15
4 * 4 = 16 - 최대값
5 * 3 = 15
6 * 2 = 12
10 * 1 = 10

*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); 
    int max = -1, tmp;
    int[] rope = new int[N];
    for (int i=0;i<N;i++){
      rope[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(rope); // 로프 오름차순 정렬

    for(int i=0;i<N;i++){
      tmp = rope[i]*(N-i); // 가장 약한 중량을 버틸 수 있는 로프부터 계산한다.
      if(tmp>max) max = tmp; // 최대 중량 업데이트
    }
    bw.write(""+max);
    bw.flush();
  }
}
