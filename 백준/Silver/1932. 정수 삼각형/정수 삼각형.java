import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N][N];
        
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0;j<=i;j++){
                int data =Integer.parseInt(temp[j]);
                if(i==0){
                    dp[i][j]=data;
                }else{
                    //시작점
                    if(j==0){
                        dp[i][j] = data + dp[i-1][j];
                    }else if(j==i){
                        dp[i][j] = data +dp[i-1][j-1];
                    }else{
                        dp[i][j] = data + Math.max(dp[i-1][j-1],dp[i-1][j]);
                    }
                }
            }
        }   // for
        int answer = 0;
        for(int i=0;i<N;i++){
            answer= Math.max(answer,dp[N-1][i]);
        }
        // int answer = Arrays.stream(result).max().orElseThrow();
        System.out.println(answer);
    }
}