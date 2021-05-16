import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{

  public static void main(String []args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int money = 1000-Integer.parseInt(br.readLine());
    int[] coin = {500,100,50,10,5,1};

    int cnt=0;
    for(int i:coin){
      cnt += money/i;
      money %= i;
      if(money==0)break;
    }

    bw.write(""+cnt);
    bw.flush();
  }
}
