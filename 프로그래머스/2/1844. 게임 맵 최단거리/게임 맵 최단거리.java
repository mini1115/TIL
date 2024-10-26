import java.io.*;
import java.util.*;
class Solution {
    static int N,M;
    static int[][] visited;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    public int solution(int[][] maps) {
        int answer = 0;
        // 가로 세로 길이
        N = maps.length;
        M = maps[0].length;
        visited = maps;
        answer = bfs(0,0);
        return answer;
    }
    static int bfs(int x,int y){
        visited[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            
            if(x==N-1 && y ==M-1){
                return visited[N-1][M-1]+1;
            }
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0|| ny<0 || nx>N-1|| ny > M-1){
                    continue;
                }else{
                    if(visited[nx][ny]==1){
                        visited[nx][ny] = visited[x][y]+1;
                        queue.add(new int[]{nx,ny});
                    }
                }
                
            }
            
        }
        return -1;
    }
}