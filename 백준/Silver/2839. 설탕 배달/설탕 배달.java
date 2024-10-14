import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // 3 ≤ N ≤ 5000
        N = Integer.parseInt(st.nextToken()); 
        // 봉지는 3킬로그램 봉지와 5킬로그램 봉지
        System.out.println(deliver(N));
        // 배달하는 봉지의 최소 개수 출력한다
        
    }
    static int deliver(int sugar){
        int answer = 0;
        while(N>0){
            if((N%5) == 0){
                // N이 5의 배수인가?
                answer += N/5 ;
                N  = N % 5 ;
            }else if(N>=3){
                N = N - 3;
                answer++;
            }else{
                return -1;
            }
        }
        
        return answer;
    }
}