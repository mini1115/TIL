import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Integer>> map;
    static boolean[] visited;
    
    public static void main(String args[]) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
    N = data[0];
    M = data[1];
    int start = data[2];
    
    map = new ArrayList<>();
    
    for(int i=0;i<N+1;i++){
        map.add(new ArrayList<Integer>());
    }
    
    for(int i=0;i<M;i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        
        map.get(index).add(value);
        map.get(value).add(index);
    }
    
    for(ArrayList<Integer> list : map){
        Collections.sort(list);
    }
    
    visited = new boolean[N+1];

    dfs(start);
    System.out.println();
    
    visited = new boolean[N+1];
    
    bfs(start);
    }
    
    static void dfs(int startNode){
        visited[startNode] = true;
        System.out.print(startNode+" ");
        ArrayList<Integer> mapInfo = map.get(startNode);
        
        for(int node:  mapInfo){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
    
    static void bfs(int startNode){
        visited[startNode] = true;
        System.out.print(startNode+" ");
        Queue<Integer> deque = new LinkedList<>();
        
        ArrayList<Integer> mapInfo = map.get(startNode);
        
        for(int node:mapInfo){
            deque.add(node);
        }
        
        while(!deque.isEmpty()){
            int node = deque.poll();
            if(!visited[node]){
                visited[node] = true;
                System.out.print(node+" ");
                ArrayList<Integer> newInfo = map.get(node);
                for(int newData:newInfo){
                    deque.add(newData);
                }
            }
        }
    }
}