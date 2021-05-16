import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(""); // "55-50+40"
    int flag = 0, result = 0;
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
