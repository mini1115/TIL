import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static boolean[][] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        // 방문처리 
        visited = new boolean[N][M];
        // 맵 만들기
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<N;i++){
            String[] data = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(data[j]);
                // 익은 토마토일 경우
                if(graph[i][j]==1){
                    // System.out.println(i+":"+j);
                    queue.offer(new int[]{i,j});
                }
            }
        }
        // System.out.println("size:"+queue.size());
        // 결과값 출력을 위한 변수
        int answer = -1;
        // 상하좌우 이동
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,-1,0,1};
        
        while(!queue.isEmpty()){
            //익은 토마토 만큼 
            int size = queue.size();
            for(int s=0;s<size;s++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                for(int i=0;i<4;i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    // 범위 체크
                    if(nx<0 || ny<0 || nx>N-1|| ny>M-1){
                        continue;
                    }
                    if(graph[nx][ny]==0){
                        graph[nx][ny]=1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            
            answer++;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j]==0){
                    // 모든 구간을 돌아도 익지 않는 토마토가 존재할 경우
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
  }
}