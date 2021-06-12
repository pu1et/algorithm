import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]), K = Integer.parseInt(str[1]);
    Integer[] arr = new Integer[K];
    int result = 0, tab_idx = 0 ;
    int[] tab = new int[N];

    str = br.readLine().split(" ");
    for(int i=0;i<K;i++){
      arr[i] = Integer.parseInt(str[i]);
    }

    for(int i=0;i<K;i++){
      int flag = 0;
      for(int j=0;j<tab_idx;j++){
        if(tab[j] == arr[i]) {
          flag = 1;
          break;
        }
      }
      if(flag == 0){

        if(tab_idx < N){
          tab[tab_idx++] = arr[i];
        }else{

          Integer[] tmp = new Integer[N]; // 각 숫자의 가장 빠른 인덱스
          Arrays.fill(tmp, 101);
          
          for(int j=0;j<N;j++){
            if(Arrays.asList(arr).contains(tab[j])){
              tmp[j] = Arrays.asList(arr).indexOf(tab[j]);
            }
          }

          tab[Arrays.asList(tmp).indexOf(Collections.max(Arrays.asList(tmp)))] = arr[i];
          ++result;

        }
      }
      arr[i] = 0;
    }

    bw.write(result+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
