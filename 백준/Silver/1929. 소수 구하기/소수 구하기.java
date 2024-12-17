import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startIndex = map[0];
        int endIndex = map[1];

        for(int i=startIndex;i<=endIndex;i++){

            if(isPrime(i)){
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
}