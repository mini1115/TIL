import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N,start;
    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
        
        N = data[0];
        int M = data[1];
        int target = data[2];
        start = data[3];
        
        graph = new ArrayList<>();
        
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }
        
        while(M-->0){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
            graph.get(input[0]).add(input[1]);
        }
        
        int[] distances = new int[N+1];
        Arrays.fill(distances,-1);
        
        bfs(distances);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=1;i<N+1;i++){
            if(i==start){
                continue;
            }
            if(distances[i] ==target){
                result.add(i);
            }
        }
        
        if(result.isEmpty()){
            System.out.println(-1);
        }
        else{
            result.forEach(System.out::println);
        }
    }
    public static void bfs(int[] distances){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        distances[start]=0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            int distance = distances[node];
            
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    distances[neighbor] = distance+1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}