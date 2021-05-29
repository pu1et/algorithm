import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
서류심사와 면접심사 결과가 다른 지원자에 비해 모두 낮은 지원자는 탈락한다.

1. 서류심사 결과 기준으로 오름차순 정렬한다.
2. 반복문을 돌며 
  -> 어차피 비교할 지원자의 서류심사 결과는 이전 지원자의 서류심사 결과보다 당연히 낮기 때문에 이전 지원자들의 면접결과 중 가장 낮은 순위보다도 낮으면 탈락함
  comp : 이전 지원자들의 면접 결과 중 가장 낮은 값
  if 비교할 면접자가 comp보다 낮으면 : 탈락
  else 비교할 면접자가 comp보다 높으면 : comp 업데이트
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); 
    int M, result;
    int[][] sample;
    String[] tmp;

    for(int i=0;i<N;i++){
      M = Integer.parseInt(br.readLine());
      sample = new int[M][2];
      result = M;
      
      for (int j=0;j<M;j++){
        tmp = br.readLine().split(" ");
        sample[j][0] = Integer.parseInt(tmp[0]);
        sample[j][1] = Integer.parseInt(tmp[1]);
      }

      Arrays.sort(sample, new Comparator<int[]>(){
        @Override
        public int compare(int[] t1, int[] t2){ 
          return t1[0]-t2[0];
        }
      });
      
      int comp = sample[0][1];
      for(int j=1;j<M;j++){
        if(comp>sample[j][1]) comp = sample[j][1];
        else result -= 1;
      }
      bw.write(""+result+"\n");
      bw.flush();
    }
  }
}
