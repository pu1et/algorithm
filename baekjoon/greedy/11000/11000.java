import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];
    PriorityQueue<Integer> timeTable = new PriorityQueue<Integer>();

    for(int i=0;i<N;i++){
      String[] tmp = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(tmp[0]);
      arr[i][1] = Integer.parseInt(tmp[1]);
    }

    Arrays.sort(arr, new Comparator<int[]>(){
      @Override
      public int compare(int[] t1, int[] t2){
        return t1[0] - t2[0];
      }
    });
    
    timeTable.offer(arr[0][1]);

    for(int i=1;i<N;i++){
      if(timeTable.peek() <= arr[i][0]){
        timeTable.poll();
        timeTable.offer(arr[i][1]);
      }else{
        timeTable.offer(arr[i][1]);
      }
    }
    
    bw.write(timeTable.size()+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
