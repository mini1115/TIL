import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[][] graph;
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 맵의 크기 N * N
        N = map[0];
        // 바이러스 개수 1 ~ K
        K = map[1];
        
        graph = new int[N][N];
        
        ArrayList<int[]> virus = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            int[] value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++){
                // 바이러스가 존재한다면
                if(value[j]!=0){
                    graph[i][j] = value[j];
                    int[] data = new int[]{value[j],0,i,j};
                    virus.add(data);
                }
            }
        }
        
        Collections.sort(virus, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[0],o2[0]);
            }
        });
        
        Queue<int[]> deque = new LinkedList<>();
        
        for(int[] temp: virus){
            deque.add(temp);
        }

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = info[0];
        int targetX = info[1]-1;
        int targetY = info[2]-1;

        int[] dx = new int[]{-1,0,1,0}; 
        int[] dy = new int[]{0,-1,0,1};
        
        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            int nVirus = temp[0];
            int time = temp[1];
            int x = temp[2];
            int y = temp[3];
            
            if(time==target){
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && ny>=0 && nx < N && ny < N){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] = nVirus;
                        int[] newVirus = new int[]{nVirus,time+1,nx,ny};
                        deque.add(newVirus);
                    }
                }
            }
        }
        
        System.out.println(graph[targetX][targetY]);
    }
}