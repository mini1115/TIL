import java.io.*;
import java.util.*;

public class Main {
    static int count,result;
    static int N,M;
    static int[][] graph;
    static int[][] temp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = data[0];
        M = data[1];
        
        result=0;
        
        temp = new int[N][M];
        
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            int[] value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<M;j++){
                graph[i][j] = value[j];
            }
        }    
        
        dfs(0);
        System.out.println(result);
    }   
    static void virus(int x, int y){
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,-1,0,1};
        int nx;
        int ny;
        
        for(int i=0;i<4;i++){
            nx = x + dx[i];
            ny  = y + dy[i];
            // 범위 확인
            if( nx>=0 & nx <N & ny>=0 & ny<M ){
                if(temp[nx][ny]==0){
                    temp[nx][ny]=2;
                    virus(nx,ny);
                }
            }
        }
    }
    
    static int cal(){
        int score = 0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j]==0){
                    score++;
                }
            }
        }
        return score;
    }
    
    static void dfs(int count){
        
        if(count==3){
        
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    temp[i][j] = graph[i][j];
                }
            }
        
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(temp[i][j]==2){
                        virus(i,j);
                    }
                }
            }
        
            result = Math.max(result,cal());
            return;
            
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
               
                if(graph[i][j]==0){
                    
                    graph[i][j]=1;
                    count++;
                    
                    dfs(count);
                    
                    graph[i][j] = 0;
                    count --;
                }
            }
        }
    }
}