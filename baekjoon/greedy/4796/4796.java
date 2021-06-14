import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
V//P * L 을 해서 L일을 몇 번 쉴 수 있는지 체크한다.
남은 날(V%P)은 L과 비교해 L보다 작으면 남은 날만큼 더하고,
L보다 크면 연속하는 날 중 최대 L일만 사용할 수 있기 때문에 L을 더한다.

1. V,P,L이 모두 0이면 테스트를 종료한다.
2. V//P*L + min(V%P, L) 을 출력한다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = 0;
    while(true){
      String[] tmp = br.readLine().split(" ");
      int L = Integer.parseInt(tmp[0]);
      int P = Integer.parseInt(tmp[1]);
      int V = Integer.parseInt(tmp[2]);

      // V,P,L이 모두 0이면 테스트 종료
      if(L+P+V == 0) break;
      
      // V//P*L + min(V%P, L) 출력
      System.out.printf("Case %d: %d\n", ++cnt, V/P*L + Math.min(V%P,L));
    }
  } 
}
