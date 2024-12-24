import java.util.*;
import java.io.*;

public class Main {
    static int N,total;
    
    static int[][] map;
    static boolean [][] visited;
    
    static final int[] dx = new int[]{-1,0,1,0};
    static final int[] dy = new int[]{0,-1,0,1};  


    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        int max = 0;

        for(int i=0;i<N;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for (int value : map[i]) {
                if (value > max) max = value;
            }
        }
        
        int result = 0;
        
        for(int height=0;height<max;height++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j] && map[i][j]>height){
                        count += dfs(height,i,j);
                    }
                }
            }
            result  = Math.max(result,count);
        }
        
        System.out.println(result);
    }
    
    static int dfs(int height,int x,int y){
 
        visited[x][y] = true;
        
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx<0 ||  ny<0||  nx>=N||  ny>=N){
                continue;
            }else{
                if(map[nx][ny]>height && !visited[nx][ny]){
                    total++;
                    dfs(height,nx,ny);
                }
            }
        }
        return 1;
    }

}