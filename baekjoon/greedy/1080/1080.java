import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
1. 행과 열을 증가시키며 행렬 B와 다른 요소가 있으면 3*3 단위로 0은 1로, 1은 0으로 교체해준다.
2. 결과적으로, 행렬 A와 B가 같지 않으면 -1을 출력한다.
*/

public class Main{
  static int[][] origin;

  // 3*3 크기의 부분 행렬에 있는 모든 원소를 뒤집음
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

    // 행과 열을 증가시키며 행렬 B와 다른 요소가 있으면 교체한 후, 연산 횟수 1 증가
    for(int i=0;i<N-2;i++){
      for(int j=0;j<M-2;j++){
        if(origin[i][j] != goal[i][j]){
          change(i,j);
          ++result;
        }
      }
    }

    // 연산 횟수 출력, but 행렬 A와 B가 같지 않으면 -1 출력
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
