import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int N = Integer.parseInt(br.readLine());
            int result = dp(N);
            System.out.println(result);
        }
    
    }
    static int dp(int n){
        if(n<0){return 0;}
        if(n==1){return 1;}
        
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if((i-1)>=0){
                dp[i] +=dp[i-1]; 
            }if((i-2)>=0){
                dp[i] +=dp[i-2];
            }if((i-3)>=0){
                dp[i] +=dp[i-3];
            }
        }
        return dp[n];
    }
}