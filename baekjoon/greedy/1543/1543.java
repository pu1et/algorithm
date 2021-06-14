import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
앞에서부터 맞는지 체크하면 된다.

1. 앞부터 1씩 인덱스를 증가하며 단어와 일치하는 지 체크한다.
2. 단어와 일치하면 인덱스를 단어의 길이만큼 증가해준다.
*/

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String doc = br.readLine();
    String word = br.readLine();
    int idx = 0, result = 0;

    while(idx <= doc.length() - word.length()){
      // 앞부터 1씩 인덱스를 증가하며 단어와 일치하는 지 체크
      if(doc.substring(idx,idx+word.length()).equals(word)){
        ++result;
        // 단어와 일치하면 단어의 길이만큼 인덱스 증가
        idx += word.length();
      }else ++idx; // 일치하지 않으면 인덱스 증가
    }

    bw.write(""+result);
    bw.flush();
    bw.close();
    br.close();
  } 
}
