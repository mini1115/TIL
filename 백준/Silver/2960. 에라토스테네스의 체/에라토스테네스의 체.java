import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int endIndex = map[0];
        int target = map[1];
        
        boolean[] isPrime = new boolean[endIndex+1];
        isPrime[1] = true;
        int count = 0;
        
        for(int i = 2; i <= endIndex; i++){
            if(!isPrime[i]){
                for (int j = i; j <= endIndex; j += i) {
                    if(!isPrime[j]){
                        isPrime[j] = true;
                        count++;
                        if(count == target){
                            System.out.print(j);
                            return;
                        }
                    }
                }
            }
        }
        
    }
}

