import java.util.*;
import java.io.*;
public class Main { 
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        graph = new ArrayList[C+1];
        visited = new boolean[C+1];
        // 각 인덱스에 ArrayList 초기화
        for (int i = 0; i <=C; i++) {
            graph[i] = new ArrayList<>();
        }
        int V = Integer.parseInt(br.readLine());
        
        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node].add(node2);
            graph[node2].add(node);
            
        }
        find(1);
        int answer = -1;

        for(int i=1;i<=C;i++){
            if(visited[i]){
                answer+=1;
            }
        }
        System.out.println(answer);
        
    }
    static void find(int x){
        visited[x]=true;
        for(int temp:graph[x]){
            if(!visited[temp]){
                find(temp);
            }
        }
        
    }
}