import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/*
거스름돈 개수가 가장 적어야 하므로 가치가 높은 동전부터 낮은 가치 순으로 동전 개수를 더해준다.
*/

public class Main{

  public static void main(String []args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int money = 1000-Integer.parseInt(br.readLine());
    int[] coin = {500,100,50,10,5,1};

    int cnt=0;            // cnt : 동전 개수
    for(int i:coin){      // 동전 개수만큼 반복
      cnt += money/i;     // 해당 가치의 동전 개수만큼 더해줌
      money %= i;         // 현재 남은 돈 업데이트
      if(money==0)break;  // 남은 돈이 없다면 for문 break
    }

    bw.write(""+cnt);
    bw.flush();
  }
}
