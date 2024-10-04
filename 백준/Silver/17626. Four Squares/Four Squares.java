import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st= new StringTokenizer(br.readLine());
    // 라그랑주는 모든 자연수는 넷 혹은 그 이하의 제곱수로 표현할 수 있다
    // 어떠한 자연수는 복수의 방법으로 표현된다.
    // 예를들면 26은 5^2 과 1^2의  합이다.
    // 또는 4^2 + 3^2 + 1^2 으로 표현할 수도 있다.
    // 자연수 n이 주어질때, n을 최소 개수의 제곱수 합으로 표현하는 프로그램
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=N;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        
        System.out.println(dp[N]);
    }
}