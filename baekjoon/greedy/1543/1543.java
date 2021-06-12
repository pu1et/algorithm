import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String doc = br.readLine();
    String word = br.readLine();
    int idx = 0, result = 0;

    while(idx <= doc.length() - word.length()){
      if(doc.substring(idx,idx+word.length()).equals(word)){
        ++result;
        idx += word.length();
      }else ++idx;
    }

    bw.write(""+result);
    bw.flush();
    bw.close();
    br.close();
  } 
}
