import java.util.*;
import java.io.*;

public class Main {
    static PriorityQueue<Integer> pq;
    static int N;
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<Integer>();
        for(int i=0;i<N;i++ ){
            pq.add(Integer.parseInt(br.readLine()));
        }
        

        
        System.out.println(cal());

    }
    static int cal(){
        int total = 0;
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
        
            int sum = first + second;
            total +=sum;
            pq.add(sum);
        }
        return total;
    }
}