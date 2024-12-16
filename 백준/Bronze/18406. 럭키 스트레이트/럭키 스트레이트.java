import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split("");
        int left = 0;
        int right = 0;
        int flag = str.length/2;
        for(int i=0;i<str.length;i++){
            if(i<flag){
                left += Integer.parseInt(str[i]);
            }else{
                right += Integer.parseInt(str[i]);
            }
            

                
        }
        if(left==right){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}