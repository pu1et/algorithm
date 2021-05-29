import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] tmp;
    int N = Integer.parseInt(br.readLine());
    int[] road = new int[N-1], spot = new int[N-1];

    tmp = br.readLine().split(" ");
    for(int i=0;i<N-1;i++){
      road[i] = Integer.parseInt(tmp[i]);
    }
    tmp = br.readLine().split(" ");
    for(int i=0;i<N-1;i++){
      spot[i] = Integer.parseInt(tmp[i]);
    }

    long min_spot = spot[0];
    long result = 0;

    for(int i=0;i<N-1;i++){
      if(min_spot > spot[i]) min_spot = spot[i];
      result += min_spot * road[i];
    }
    System.out.println(result);
  } 
}
