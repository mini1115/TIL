import java.io.*;
import java.util.*;

public class Main {
    static int K,N;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st= new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- >0){
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            // K층 N호
            dp  = new int[K+1][N+1];
            search(dp);
            System.out.println(dp[K][N]);
        }
        
    }
    static void search(int[][] dp){
        if(K==0){
            dp[K][N]=N;
        }else{
            for(int i=1;i<=N;i++){
                dp[0][i] = i;
            }
            // K>0인경우
            for(int i=1;i<=K;i++){
                for(int j=1;j<=N;j++){
                   dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
    }
}