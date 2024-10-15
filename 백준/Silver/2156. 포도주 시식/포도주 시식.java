import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 계단 케이스 입력받기
        int T = Integer.parseInt(br.readLine());
        int[] wine = new int[T+1];
        for(int i=1;i<=T;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        // 각 계단마다 최대값을 담을 dp 배열
        int[] dp = new int[T+1];
        dp[1] = wine[1];
        if(T>1){
           dp[2] = wine[1] + wine[2];
        }
        if(T>2){
            for(int i=3;i<=T;i++){
                int data = Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i-1]+wine[i]);
                dp[i] = Math.max(data,dp[i-1]);
            }
        }
        System.out.println(dp[T]);
    }
}