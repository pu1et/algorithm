import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{

    static class Box implements Comparable<Box>{
        int start, end, w;
        Box(int start, int end, int w){
            this.start = start;
            this.end = end;
            this.w = w;
        }
        @Override
        public int compareTo(Box target){
            if(this.start == target.start) return this.end - target.end;
            else return this.start - target.start;
        }
    }

    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Box> pq = new PriorityQueue<Box>();

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]), C = Integer.parseInt(tmp[1]);
        int M = Integer.parseInt(br.readLine());
        int result = 0;
        int[] truck = new int[N+1];

        for(int i=0;i<M;i++){
            tmp = br.readLine().split(" ");
            pq.offer(new Box(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }

        for(int i=1;i<=N;i++){
            result += truck[i];

            int[] load = new int[N+1];
            while(!pq.isEmpty()){
                if(pq.peek().start == i){
                    int end = pq.peek().end, w = pq.poll().w;
                    load[end] = w;
                }else break;
            }

            int check = C;
            boolean flag = false;
            for(int j=i+1;j<=N;j++){
                if(flag) truck[j] = 0;
                else{
                    if(truck[j] + load[j] < check) {
                        check -= (truck[j] + load[j]);
                        truck[j] += load[j];
                    }
                    else{
                        truck[j] = check;
                        flag = true;
                    }
                }
            }
        }

        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
    }
}
