import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(divide(N));

    }
    static int divide(int N){
        // 5kg 나눌수 있는 경우 큰 몫부터 0까지 내려간다.
        for(int i=N/5;i>=0;i--){
            int remain = N -(5*i);
            //3으로 나눈 나머지가 0일 경우
            if(remain %3 ==0){
                return (i+ remain/3);
            }
        }
        return -1;
    }
    
}