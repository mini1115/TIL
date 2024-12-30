import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] dp = new int[N];
        
        Arrays.fill(dp,1);
        
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(data[i]>=data[j]){
                    continue;
                }else{
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        int result = 0;
        for(int temp:dp){
            result = Math.max(result,temp);
        }
    
        System.out.println(N-result);
    }
}