import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    
    static int[][] map;
    static boolean [] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            // 양방향 그래프 
            graph.get(node2).add(node1);
        }
        
        int result = 0;
        
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }    
        }
        
        System.out.println(result);
    }
    
    static void dfs(int node){
        visited[node] = true;
        
        for(int data : graph.get(node)){
            if(!visited[data]){
                dfs(data);
            }
        }
        
    }
}