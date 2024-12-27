import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] info = new int[N][2];
        for(int i=0;i<N;i++){
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // time
            info[i][0] = data[0];
            // value
            info[i][1] = data[1];
        }
        
        
        int[] dp = new int[N+1];
        
        int maxValue = 0;
        
        for(int i=N-1;i>=0;i--){
            int time = info[i][0] + i;
            
            if(time<=N){
                dp[i] = Math.max(maxValue,dp[time]+info[i][1]);
                
                maxValue = dp[i];
            }else{
                dp[i] = maxValue;
            }
        }
        
        System.out.println(maxValue);
    }
}