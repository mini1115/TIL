### DFS (Depth - First Search)
    그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다. 
    - 스택 자료구조를 이용하여 동작가능하다.
    - 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
    - 2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있다면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없다면 스택에서 최상단 노드를 꺼낸다.
    - 3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
    - '방문 처리'는 스택에 한 번 삽입되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미한다. 방문 처리르 함으로써 각 노드를 한 번씩만 처리할 수 있다.

``` java
import java.util.*;
public class Main {
    static boolean[] visited;
    public static void main(String args[]) {
        int[][] graph = new int[][]{{},{2,3,8},{1,7},{1,4,5},{3,5},{3,4},{7},{2,6,8},{1,7}};
        visited = new boolean[graph.length];
        dfs(graph,1);
    }
    static void dfs(int[][] graph,int v){
        visited[v] = true;
        System.out.print(v+" ");
        for(int i:graph[v]){
            if(!visited[i]){
                dfs(graph,i);
            }
        }
    }
}
// 출력 결과 : 1 2 7 6 8 3 4 5 
```
