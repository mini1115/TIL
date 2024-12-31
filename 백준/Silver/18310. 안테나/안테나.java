import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] house = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(house);
        
        int middlePoint = N/2;
        
        boolean isTwo = true;
        
        if(N%2==0){
            // 짝수라면
            isTwo = false;
        }
        
        if(!isTwo){
            middlePoint --;
        }
        
        
        int result = middlePoint;
        
        
        
        System.out.println(house[result]);
        
        
        
        
    }
}