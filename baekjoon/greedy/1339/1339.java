import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
각 자리의 알파벳에 10의 자릿수를 적용시켜
내림차순으로 정렬하여 가장 높은 가치의 알파벳부터 9~0까지 할당하여 계산한다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(br.readLine()); // N
    String[][] str = new String[N][];
    Map<String, Integer> map = new HashMap<String, Integer>();
    int tmp, result = 0,len;

    // {알파벳, 자릿수} 형식으로 10의 자릿수를 적용시켜 계산
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

    // 가장 높은 가치의 알파벳부터 내림차순으로 정렬
    List<String> keySet = new ArrayList<>(map.keySet());
    keySet.sort((t1,t2)->map.get(t2)-map.get(t1));

    // 내림차순한 알파벳 순서대로 9-0 할당
    tmp = 9;
    for(String key: keySet){
      map.put(key,tmp--);
    }

    // 할당된대로 값 계산
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
