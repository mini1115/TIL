import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        
        boolean flag = false;
        
        ArrayList<String> numArr = new ArrayList<>();
        numArr.add(A);
        while(!flag){
            int total = 0;
            for(char c : A.toCharArray()){
                int num  =  Character.getNumericValue(c);
                total += Math.pow(num,P);
            }
            String newA = Integer.toString(total);
            if(numArr.indexOf(newA)!=-1){
                System.out.println(numArr.indexOf(newA));
                return;
            }else{
                numArr.add(newA);
                A = newA;
            }
        }
    }

}