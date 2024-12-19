import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long [] data = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            data[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(data);
        
        long [] result = new long[2];
        long sum= Long.MAX_VALUE;
        
        int start =0;
        int end = N-1;
        
        while(start <  end){
            long nowSum = data[start] + data[end];
            
            if (Math.abs(nowSum) < Math.abs(sum)) {
                result[0] = data[start];
                result[1] = data[end];
                sum = nowSum;
            }
            
            if(nowSum>0){
                end--;
            }else{
                start++;
            }
        }
        
        System.out.println(result[0]+" "+result[1]);
    }
}