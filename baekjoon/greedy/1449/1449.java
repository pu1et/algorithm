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
    int N = Integer.parseInt(tmp[0]), L = Integer.parseInt(tmp[1]);
    int[] thing = new int[N];

    tmp = br.readLine().split(" ");
    for(int i=0;i<N;i++){
      thing[i] = Integer.parseInt(tmp[i]);
    }
    Arrays.sort(thing);

    int result = 0;
    int idx = 0;

    for(int t: thing){
      if(idx < t){
        ++result;
        idx = t + L - 1;
      }
    }

    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  } 
}
