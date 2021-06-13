import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
1. 가장 나중에 변경하는 수 기준으로 변경
2. 이후에 가장 적게 사용되는 수 기준으로 변경
*/

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
      // 이미 있는 전기용품은 건너뛰기
      if(flag == 0){
        // 탭에 전기용품 채우기
        if(tab_idx < N){
          tab[tab_idx++] = arr[i];
        }else{

          Integer[] tmp = new Integer[N]; // 각 숫자의 가장 빠른 인덱스
          Arrays.fill(tmp, 101); // 이후에 나타나지 않는 용품의 인덱스는 101
          
          // 이후에 전기용품이 가장 빨리 나타나는 인덱스 저장
          for(int j=0;j<N;j++){
            if(Arrays.asList(arr).contains(tab[j])){
              tmp[j] = Arrays.asList(arr).indexOf(tab[j]);
            }
          }
          // tmp중 가장 나중에 변경되는 전기용품 교체
          tab[Arrays.asList(tmp).indexOf(Collections.max(Arrays.asList(tmp)))] = arr[i];
          ++result;

        }
      }
      arr[i] = 0; // 갔다온 표시
    }

    bw.write(result+"\n");

    bw.flush();
    bw.close();
    br.close();
  } 
}
