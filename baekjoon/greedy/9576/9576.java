import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int test = Integer.parseInt(br.readLine());
    for(int t=0;t<test;t++){
      String[] tmp = br.readLine().split(" ");
      int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);
      int[][] apply = new int[M][2];
      int[] book = new int[N+1];
      int cnt = 0;

      for(int m=0;m<M;m++){
        tmp = br.readLine().split(" ");
        apply[m][0] = Integer.parseInt(tmp[0]);
        apply[m][1] = Integer.parseInt(tmp[1]);
      }
      // [1] -> [0] 정렬
      Arrays.sort(apply, new Comparator<int[]>(){
        @Override
        public int compare(int[] t1, int[] t2){
          return t1[1] - t2[1];
        }
      });

      // 반복문 돌며 학생 선정
      for(int i=0;i<M;i++){
        for(int j=apply[i][0];j<=apply[i][1];j++){
          if(book[j] != 1){
            book[j] = 1;
            ++cnt;
            break;
          }
        }
      }

      bw.write(cnt+"\n");
    }
    
    bw.flush();
    bw.close();
    br.close();
  } 
}
