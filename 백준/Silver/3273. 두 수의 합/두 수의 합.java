import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int [] data = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int target = Integer.parseInt(br.readLine());
        
        Arrays.sort(data);
        
        int count =0;
        int startIndex = 0;
        int endIndex = N-1;

        while(startIndex < endIndex){
            int sum = data[startIndex] + data[endIndex];
            if(sum==target){
                count++;
                startIndex++;
                endIndex--;
            }else if(sum > target){
                endIndex--;
            }else if(sum<target){
                startIndex ++;
            }
        }
        
        System.out.println(count);
    }
}