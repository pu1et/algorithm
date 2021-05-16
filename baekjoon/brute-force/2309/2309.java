import java.util.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main{
  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int[] dwarf = new int[9];

    // 입력받고 정렬
    for(int i=0;i<9;i++){
      dwarf[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(dwarf);
    
    // for문
    int flag = 0;
    for(int i=0;i<3;i++){
      for(int j=i+1;j<4;j++){
        for(int k=j+1;k<5;k++){
          for(int l=k+1;l<6;l++){
            for(int m=l+1;m<7;m++){
              for(int n=m+1;n<8;n++){
                for(int o=n+1;o<9;o++){
                  if((dwarf[i]+dwarf[j]+dwarf[k]+dwarf[l]+dwarf[m]+dwarf[n]+dwarf[o]) == 100){
                    bw.write(dwarf[i]+"\n"+dwarf[j]+"\n"+dwarf[k]+"\n"+dwarf[l]+"\n"+dwarf[m]+"\n"+dwarf[n]+"\n"+dwarf[o]+"\n");
                    bw.flush();
                    flag = 1;
                    break;
                  }
                  if(flag == 1) break;
                }
                if(flag == 1) break;
              }
              if(flag == 1) break;
            }
            if(flag == 1) break;
          }
          if(flag == 1) break;
        }
        if(flag == 1) break;
      }
      if(flag == 1) break;
    }
  } 
}
