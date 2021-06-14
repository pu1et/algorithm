import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
  static int[] parent;

  static int find(int x){
      if(parent[x] == x) return parent[x];
      else{
        parent[x] = find(parent[x]);
        return parent[x];
      }
  }

  static void union(int x, int y){
      x = find(x);
      y = find(y);
      parent[x] = y;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int G = Integer.parseInt(br.readLine()), P = Integer.parseInt(br.readLine());
    int[] flight = new int[P];
    for(int i=0;i<P;i++){
      flight[i] = Integer.parseInt(br.readLine());
    }
    parent = new int[G+1];
    for(int i=1;i<=G;i++){
      parent[i] = i;
    }

    int result = 0;
    for(int f: flight){
      int c = find(f);
      if(c == 0) break;
      else{
        ++result;
        union(c, c-1);
      }
    }

    bw.write(result+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
