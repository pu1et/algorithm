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

    String[] tmp = br.readLine().split(" ");
    int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);

    origin = new int[N][M];
    int[][] goal = new int[N][M];
    int result = 0;

    for(int i=0;i<N;i++){
        tmp = br.readLine().split("");
        for(int j=0;j<M;j++){
          origin[i][j] = Integer.parseInt(tmp[j]);
        }
    }

    for(int i=0;i<N;i++){
        tmp = br.readLine().split("");
        for(int j=0;j<M;j++){
          goal[i][j] = Integer.parseInt(tmp[j]);
        }
    }

    for(int i=0;i<N-2;i++){
      for(int j=0;j<M-2;j++){
        if(origin[i][j] != goal[i][j]){
          change(i,j);
          ++result;
        }
      }
    }

    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(origin[i][j] != goal[i][j]){
          result = -1;
          break;
        }
      }
      if(result == -1)break;
    }
    System.out.println(result);
  } 
}
