import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
  static int[][] origin;

  public static void change(int row, int col){
    for(int i=row;i<row+3;i++){
      for(int j=col;j<col+3;j++){
        if(origin[i][j] == 1) origin[i][j] = 0;
        else origin[i][j] = 1;
      }
    }
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split("");
    int[] arr = {0,0};
    int flag = Integer.parseInt(tmp[0]);
    ++arr[flag];

    for(int i=1;i<tmp.length;i++){
      int comp = Integer.parseInt(tmp[i]);
      if(flag != comp){
        flag = comp;
        ++arr[flag]; 
      }
    }
    System.out.println(Math.min(arr[0],arr[1]));
  } 
}
