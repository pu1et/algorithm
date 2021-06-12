import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

  public static void main(String []args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    long N = Long.parseLong(br.readLine());
    long result = 0;

    while(++result*(result+1)/2 <= N){}
    System.out.println(result-1);
  } 
}
