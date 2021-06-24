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
    String[] tmp = br.readLine().split(" ");
    int[] dice = new int[6];
    int max = 0; long result = 0;
    
    for(int i=0;i<6;i++){
      dice[i] = Integer.parseInt(tmp[i]);
      if(max < dice[i]) max = dice[i];
      result += dice[i];
    }

    if(N == 1) result -= max;
    else{
      result = 0;
      long[] min_dice = new long[3];
      min_dice[0] = Math.min(dice[0], dice[5]);
      min_dice[1] = Math.min(dice[1], dice[4]);
      min_dice[2] = Math.min(dice[2], dice[3]);

      Arrays.sort(min_dice);

      
      result = (N-2L)*(5L*N-6)*min_dice[0];
      result += (2L*N-3)*4L*(min_dice[0]+min_dice[1]);
      result += 4L*Arrays.stream(min_dice).sum();
    }

    bw.write(""+result);    
    bw.flush();
    bw.close();
    br.close();
  } 
}
