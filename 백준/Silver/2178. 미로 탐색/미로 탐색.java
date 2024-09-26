import java.util.*;
import java.io.*;
class Point {
    private int x;
    private int y;
    
    public Point(int x,int y){
        this.x = x;
        this.y= y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
public class Main {
    static int N,M;
    static boolean[][] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        graph = new int[N][M];
        
        for(int i=0;i<N;i++){
            String[] data = br.readLine().split("");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(data[j]); 
            }
        }
        
        Point startPoint = new Point(0,0);
        bfs(startPoint);
        System.out.println(graph[N-1][M-1]);
    }
    static void bfs(Point point){
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,-1,0,1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        while(!queue.isEmpty()){
            Point nowPoint = queue.poll();
            int px =  nowPoint.getX();
            int py = nowPoint.getY();
            visited[px][py] = true;
            for(int i=0;i<4;i++){
                int nx = px+dx[i];
                int ny = py+dy[i];
                if(nx<0||ny<0||nx>N-1||ny>M-1){
                    continue;
                }
                if(!visited[nx][ny]&&graph[nx][ny]==1){
                    graph[nx][ny] = graph[px][py]+1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }
}