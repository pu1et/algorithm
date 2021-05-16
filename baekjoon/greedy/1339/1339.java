import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); // N
    String[][] str = new String[N][];
    Map<String, Integer> map = new HashMap<String, Integer>();
    int tmp, result = 0,len;


    for(int i=0;i<N;i++){
      str[i] = br.readLine().split("");
      len = str[i].length;
      for(int j=0;j<len;j++){
        if(!map.containsKey(str[i][j])) map.put(str[i][j],(int)Math.pow(10,len-j-1));
        else{
          tmp = map.get(str[i][j]);
          map.put(str[i][j],tmp+(int)Math.pow(10,len-j-1));
        }
      }
    }

    List<String> keySet = new ArrayList<>(map.keySet());
    keySet.sort((t1,t2)->map.get(t2)-map.get(t1));

    tmp = 9;
    for(String key: keySet){
      map.put(key,tmp--);
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.setLength(0);
      len = str[i].length;
      for(int j=0;j<len;j++){
        sb.append(map.get(str[i][j]));
      }
      result += Integer.parseInt(sb.toString());
    }

    bw.write(""+result);
    bw.flush();
  }
}
