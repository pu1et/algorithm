import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 최소 값이기 때문에 -단위로 부분값을 빼면 된다.
 처음 -를 만나기 전까지 수는 모두 + 해주고, 그 이후 수는 모두 - 해주면 된다.
  
 1. 문자열을 문자 단위로 나눠준다.
 2. if - 만나면 :
     if - 이전이라면 : ex) 55-X 인 경우
       결과값 += 수
       flag = 1
     else - 이후라면:
       결과값 -= 수
     
    else + 를 만나면: 
     if - 이전이라면 : ex) 55+40-X 인 경우
       결과값 += 수
     else - 이후라면 : 
       결과값 -= 수
       
    else 그냥 숫자면: 문자열을 더해줌
*/

public class Main{
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(""); // "55-50+40-70" -> [5,5,-,5,0,+,4,0,-,7,0]
    int flag = 0, result = 0; // flag : - 이후인지 (0: - 이전, 1: 이후) 
    StringBuilder tmp = new StringBuilder();

    for(String s: str){
      if(s.equals("-")){
        if(flag==0){
          result+=Integer.parseInt(tmp.toString());
          flag = 1;
        }else{
          result-=Integer.parseInt(tmp.toString());
        }
        tmp.setLength(0);
      }else if(s.equals("+")){
        if(flag==0) result+=Integer.parseInt(tmp.toString());
        else result-=Integer.parseInt(tmp.toString());
        tmp.setLength(0);
      }else{ 
        tmp.append(s);
      }
    }
    
    if(flag==1) result-=Integer.parseInt(tmp.toString());
    else result+=Integer.parseInt(tmp.toString());

    bw.write(""+result);
    bw.flush();
  }
}
