import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while(T-- >0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(combination(n,r));
        }
        
        
    }
    static int combination(int n,int r){
        int[][] dp = new int[n+1][r+1];
        // 파스칼 삼각형 이용용
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i,r);j++){
                if(j==0 || i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][r];
    }
}