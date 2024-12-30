import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        
        for(int i=1;i<=N;i++){
            int [] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = temp[0];
            P[i] = temp[1];
        }
        
        int maxValue = 0;
        
        int[] dp = new int[N+2];
        
        for(int i=N;i>=1;i--){
            int time = T[i] + i;
            
            if(time <=N+1){
                dp[i] = Math.max(maxValue,P[i]+dp[time]);
                maxValue = dp[i]; 
            }else{
                dp[i] = maxValue;
            }
        }
        
        System.out.println(maxValue);
    }
}