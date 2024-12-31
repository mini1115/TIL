import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String [][] score = new String[N][4];

        for(int i=0;i<N;i++){
            String[] data = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);

            score[i][0] = data[0];
            score[i][1] = data[1];
            score[i][2] = data[2];
            score[i][3] = data[3];
        }
        
        // String, int data1, int data2, int data3
        // 이름 ,   국어 ,  영어 ,  수학
        // 정렬의 기준 
        // 1. 국어 점수 내림차순
        // 2. 영어 점수 오름차순
        // 3. 수학 점수 내림차순
        // 4. 이름 사전순
    
        Arrays.sort(score,new Comparator<String[]>(){
           public int compare(String[] s1, String[] s2){
               
               int koreanScore = Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
               if(koreanScore !=0) return koreanScore;
               
               int EnglishScore = Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
               if(EnglishScore !=0) return EnglishScore;
               
               int MathScore = Integer.parseInt(s2[3]) - Integer.parseInt(s1[3]);
               if(MathScore !=0) return MathScore;
               
               return ((String)s1[0]).compareTo((String)s2[0]);
           } 
        });
        
        
        for(int i=0;i<N;i++){
            System.out.println(score[i][0]);
        }
    }
}