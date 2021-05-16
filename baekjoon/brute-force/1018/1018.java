import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] str = br.readLine().split(" ");
    int N, M,change_b,change_w,flag_b,flag_w, result = 64;
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    String[][] chess = new String[N][M];
    String[] b={"B","W","B","W","B","W","B","W"};
    String[] w={"W","B","W","B","W","B","W","B"};
    String[] tmp1,tmp2;

    for(int i=0;i<N;i++){
      chess[i] = br.readLine().split("");
    }

    for(int row=0;row<N-7;row++){
      for(int col=0;col<M-7;col++){
        change_b=0; change_w=0;
        tmp1=b;tmp2=w;
        flag_b=1;flag_w=0;// 1 == b, 0 == a
        for(int i=0;i<8;i++){
          for(int j=0;j<8;j++){
            if(!chess[row+i][col+j].equals(tmp1[j])) ++change_b;
            if(!chess[row+i][col+j].equals(tmp2[j])) ++change_w;
    
          }
          if(flag_b==1) {
            tmp1=w;
            flag_b = 0;
          }else {
            tmp1 = b;
            flag_b = 1;
          }
          if(flag_w==1) {
            tmp2=w;
            flag_w = 0;
          }else {
            tmp2 = b;
            flag_w = 1;
          }
        }
        if(result>=change_b) result = change_b;
        if(result>=change_w) result = change_w; 
      }
    }

    bw.write(""+result);
    bw.flush();
  } 
}
