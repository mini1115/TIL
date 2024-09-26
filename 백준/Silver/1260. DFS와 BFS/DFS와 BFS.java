import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static boolean[ ] visited;
    static int[][] graph;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 수
        N = Integer.parseInt(st.nextToken());
        // 간선의 수
        int V = Integer.parseInt(st.nextToken());
        // 시작점
        int start = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
            
        visited = new boolean[N+1];
        dfs(start);
        System.out.println();
        visited = new boolean[N+1];
        bfs(start);        
    }
    static void dfs(int Node){
        visited[Node] = true;
        System.out.print(Node+" ");
        for(int i=1;i<N+1;i++){
            if(graph[Node][i]==1 && !visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int Node){
        //  큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int i=1;i<N+1;i++){
                if(graph[now][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}