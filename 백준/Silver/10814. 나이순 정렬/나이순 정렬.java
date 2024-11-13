import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        Map<Integer,ArrayList<String>> info = new TreeMap<>();

        for(int i=0;i<N;i++){
            String[] data = br.readLine().split(" ");
            int age = Integer.parseInt(data[0]);
            String name = data[1];
            // 
            if(!info.containsKey(age)){
                info.put(age,new ArrayList<>());
                info.get(age).add(name);
            }else{
                info.get(age).add(name);
            }
            
        } //for
        
        //Map을 key값으로 오름차순 정렬, ArrayList 순서대로 출력.
       
        for(int age:info.keySet()){
            for(int i=0;i<info.get(age).size();i++){
                System.out.println(age+" "+info.get(age).get(i));
            }
        }
    }

}