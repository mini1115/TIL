import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(data[i]>data[j]){
                    // 항상 이전보다 크지 않을 경우가 존재한다 {3,2,5,1,6}
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int result = Arrays.stream(dp).max().orElseThrow(NoSuchElementException::new);
        System.out.println(result);
    }
}