import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int A = Integer.parseInt(str[0]), B = Integer.parseInt(str[1]);
    int result = 1 ;

    while(B>A){
      String tmp = ""+B;
      if(tmp.charAt(tmp.length()-1) == '1'){
        B = Integer.parseInt(tmp.substring(0,tmp.length()-1));
        ++result;
      }else if(B%2 == 0){
        B/=2;
        ++result;
      }else break;
    }
    if(B!=A) bw.write("-1");
    else bw.write(result+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
