import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
B에서 A로 바꾸는 연산을 한다.

1. 끝에 1이 있으면 잘라낸다.
2. 2의 배수면 나눈다.
3. 그 외 홀수는 2로 나누어떨어질 수 없기 때문에 -1출력
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int A = Integer.parseInt(str[0]), B = Integer.parseInt(str[1]);
    int result = 1 ;

    while(B>A){
      String tmp = ""+B;
      // 끝에 1이 있으면 자름
      if(tmp.charAt(tmp.length()-1) == '1'){
        B = Integer.parseInt(tmp.substring(0,tmp.length()-1));
        ++result;
      // 2의 배수면 나눔
      }else if(B%2 == 0){
        B/=2;
        ++result;
      // 그 외 홀수는 2로 나누어떨어질 수 없기 때문에 -1 출력
      }else break;
    }
    if(B!=A) bw.write("-1");
    else bw.write(result+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
