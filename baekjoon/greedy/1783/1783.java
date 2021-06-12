import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp = br.readLine().split(" ");
    int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);
    int result = 0;

    if(N == 1) result = 1;
    else if(N == 2){
      if(M <= 6) result = (M+1)/2;
      else result = 4;
    }else{
      if(M <= 4) result = M;
      else if(M < 7) result = 4;
      else result = M - 2;
    }

    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
