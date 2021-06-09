import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  static int[] find = {'U', 'C', 'P', 'C'};

  public static int find_UCPC(String text){
    int find_idx = 0;
    
    for(char t : text.toCharArray()){
      if(t == find[find_idx]){
        ++find_idx;
        if(find_idx == 4) return 1;
      }
    }
    return 0;
  }

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String text = br.readLine();

    int result = find_UCPC(text);

    if(result == 1) bw.write("I love UCPC");
    else bw.write("I hate UCPC");
    
    bw.flush();
    bw.close();
    br.close();
  } 
}
