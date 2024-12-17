import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startIndex = map[0];
        int endIndex = map[1];

        boolean[] judge = isPrime2(endIndex);
        
        for(int i=startIndex;i<=endIndex;i++){
            if(!judge[i]){
                System.out.println(i);
            }
        }
        
    }
  static boolean isPrime(int x){
      if(x<2){
          return false;
      }
      double judge = Math.sqrt(x);
      for(int i=2;i<=(int)judge;i++){
          if(x%i == 0){
              return false;
          }
      }
      return true;
  }
//   에라토스테네스의 체
    static boolean[] isPrime2(int x){
        boolean[] judge = new boolean[x+1];
        judge[1] = true;
        for(int i=2;i<=Math.sqrt(x);i++){
            int j=2;
            if(!judge[i]){
                while((i*j)<=x){
                    judge[i*j] = true;
                    j++;
                }
            }
        }
        return judge;
        
    }
}