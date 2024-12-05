import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);
        
        Queue<Integer> deque = new LinkedList<Integer>();
        for(int i=1;i<N+1;i++){
            deque.add(i);
        }
        StringBuilder result = new StringBuilder("<");
        
        while(!deque.isEmpty()){
            for(int i=0;i<K;i++){
                int value = deque.poll();
                if(i==K-1){
                    result.append(value);
                    result.append(", ");
                }else{
                    deque.add(value);
                }
                
            }
        }
        result.deleteCharAt(result.length()-1);
        result.deleteCharAt(result.length()-1);
        result.append(">");
        System.out.println(result);
        }   
}