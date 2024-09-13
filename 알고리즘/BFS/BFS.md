### BFS(Breadth First Search) '너비 우선 탐색'
    가까운 노드부터 탐색하는 알고리즘
    <-> DFS 는 최대한 멀리 있는 노드를 우선으로 탐색한느 방식으로 동작한다고 했는데 BFS는 그 반대다
    구현방식 : 큐 자료구조를 이용하는 것이 정석이다. 
    인접한 노드를 반복적으로 큐에 넣도록 알고리즘을 작성하면 자연스럽게 먼저 들어온 것이 먼저 나가게 되어, 가까운 노드부터 탐색을 진행하게 된다.
    1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
    2. 큐에 노드를 꺼내 해당 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
    3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.


```java
import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String args[]) {
        visited = new boolean[9];
        graph = new int[][]{{},{2,3,8},{1,7},{1,4,5},{3,5},{3,4},{7},{2,6,8},{1,7}};
        
        bfs(1);
    }
    static void bfs(int start){
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v+" ");
            
            for(int i : graph[v]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
// 출력 결과 : 1 2 3 8 7 4 5 6 
```
