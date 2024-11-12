import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 자연수 N, 정수 K ex) 5,2 => 10 5C2 , NCK
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int result = cal(N,K);
    // int result = factorial(N) /( factorial(K) * factorial(N-K)) ;
    System.out.println(result);
    
  }
//   public static int factorial(int num){
//       if(num==1){
//           return 1;
//       }
//       else{
//           return num * factorial(num-1);
//       }
//   }
    static int cal(int N,int K){
        if(N==K || K==0){
            return 1;
      }
        else{
            return cal(N-1,K) + cal(N-1,K-1);
      }
  }
}