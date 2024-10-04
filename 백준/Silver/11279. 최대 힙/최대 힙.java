import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // 첫째 줄에 연산의 개수 N
        int T = Integer.parseInt(st.nextToken());
    
        // 배열에 자연수 x를 넣는다.(x>0)
        // (x==0) 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while(T-- >0){
            int N = Integer.parseInt(br.readLine());
            if(N==0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else{
                    int data = queue.poll();
                    System.out.println(data);
                }
            }else{
                queue.add(N);
            }
        }
    }
}