import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int result=0;
        // 세로 N 가로 M 인벤토리 I
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int I =Integer.parseInt(st.nextToken());
        int max = 0;
        int min  = Integer.MAX_VALUE;
        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            String[] data = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                int value = Integer.parseInt(data[j]);
                map[i][j] = value;
                if(min>value){
                    min = value;
                }
                if(max<value){
                    max = value;
                }
            }
        }
        int judge = 99999999;
        
        for(int l=min;l<=max;l++){
            int time = 0;
            int remain = I;
            
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    // 높이가 클 경우우
                    if(l<map[i][j]){
                        time+= ((map[i][j]-l)*2);
                        remain += (map[i][j]-l);
                    }else{ 
                        time += (l-map[i][j]);
                        remain -= (l-map[i][j]);
                    }
                }
                
            }
            // 남은 블록수가 음수일때때
            if(remain <0){
                break;
            }
            if(judge>=time){
                judge = time;
                result = l; 
            }
            
        }
        System.out.println(judge+" "+result);
    }
}