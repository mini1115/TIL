import java.util.*;
import java.io.*;
public class Main {
    static int N,M,answer;
    static boolean[][] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 결과출력을 위한 배열
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 정사각형 지도 크기 N
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        // 방문처리 
        visited = new boolean[N][N];
        // 맵 만들기
        for(int i=0;i<N;i++){
            String data = br.readLine();
            for(int j=0;j<N;j++){
                graph[i][j] = data.charAt(j) -'0';
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer = 0;
                if(graph[i][j]==1&&!visited[i][j]){
                    dfs(i,j);
                    result.add(answer);
                }
                
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(System.out::println);
    }
    static void dfs(int x,int y){
        if(x<0 || y <0 || x>N-1 || y>N-1){
            return;
        }
        // 방문한 적이 있거나 해당 지점에 집이 없는 경우
        if(visited[x][y] || graph[x][y]==0){
            return;
        }
        visited[x][y] = true;
        answer++;
        dfs(x,y+1);
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y-1);
        
    }
}