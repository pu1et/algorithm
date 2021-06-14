import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
도로를 이용할 때, 해당 도로 이전의 주유소 중 가장 저렴한 주유소의 기름을 사용하도록 한다
즉, 사용하던 주유소가 더 저렴하면 계속 그 기름으로 도로를 이용하고 
도착한 주유소가 더 저렴하면 그 주유소의 기름으로 교체한다

1. 처음 주유소를 가장 저렴한 주유소로 설정한다.
2. 주유소를 도착할 때마다 리터당 값을 비교하고,
   더 저렴한 주유소의 기름을 사용해 비용을 계산한다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp;
    int N = Integer.parseInt(br.readLine());
    int[] road = new int[N-1], spot = new int[N-1];

    tmp = br.readLine().split(" ");
    for(int i=0;i<N-1;i++){
      road[i] = Integer.parseInt(tmp[i]);
    }
    tmp = br.readLine().split(" ");
    for(int i=0;i<N-1;i++){
      spot[i] = Integer.parseInt(tmp[i]);
    }

    // 처음 주유소를 가장 저렴한 주유소로 설정
    long min_spot = spot[0];
    long result = 0;

    for(int i=0;i<N-1;i++){
      // 주유소를 도착할 때마다 리터당 값 비교
      if(min_spot > spot[i]) min_spot = spot[i];
      // 현재 위치 기준 가장 저렴한 주유소의 기름을 사용해 비용을 계산
      result += min_spot * road[i];
    }
    System.out.println(result);
  } 
}
