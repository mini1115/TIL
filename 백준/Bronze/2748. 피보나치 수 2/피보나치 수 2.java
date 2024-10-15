import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // n번째 피보나치 수 목표
        int N = Integer.parseInt(st.nextToken());
        
        long [] dp = new long[N+1];
        if(N==0){
            System.out.println(0);
            return;
        }
        if(N==1){
            System.out.println(1);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}