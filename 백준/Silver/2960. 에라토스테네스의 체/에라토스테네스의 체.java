import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int endIndex = map[0];
        int target = map[1];
        
        boolean[] judge = new boolean[endIndex+1];
        judge[1] = true;
        int count = 0;
        
        for(int i=2;i<=endIndex;i++){
            if(!judge[i]){
                judge[i] = true;
                count++;
                if(count==target){
                    System.out.println(i);
                    return;
                }
                else{
                    int j=2;
                    
                    while( (i*j) <= endIndex){
                        if(!judge[i*j]){
                            judge[i*j] = true;
                            count++;
                            if(count==target){
                                System.out.println(i*j);
                                return;
                            }
                        }
                        j++;
                    }
                }
            }
        }
        
    }
}

