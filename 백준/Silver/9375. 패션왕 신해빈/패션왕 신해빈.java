import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st= new StringTokenizer(br.readLine());
        // 테스트 케이스 
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            // 의상 갯수
            int N =  Integer.parseInt(br.readLine());
            Map<String,Integer> kind = new HashMap<>();
            for(int i=0;i<N;i++){
                String[] data = br.readLine().split(" ");
                // 해당 키가 존재하지 않는 경우
                if(!kind.containsKey(data[1])){
                    kind.put(data[1],1);
                }else{
                    // 해당 종류가 존재한다면
                    kind.put(data[1],kind.get(data[1])+1);
                }

            } // for문
            int result = 1;
            for(int val:kind.values()){
                // System.out.println(val);
                result *= (val+1);
            }
            System.out.println(result-1);
        } // while문
    }
}