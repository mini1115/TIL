import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int answer;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            answer = 0;

            // 가로길이
            M = Integer.parseInt(st.nextToken());
            // 세로길이
            N = Integer.parseInt(st.nextToken());
            graph = new int[M][N];
            visited = new boolean[M][N];

            // 배추의 개수
            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                // 입력받기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1; // 배추가 있는 위치를 1로 표시
            }

            // 그래프 탐색
            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    // 방문하지 않았고 배추가 있는 경우
                    if (!visited[a][b] && graph[a][b] == 1) {
                        dfs(a, b); // DFS 호출
                        answer++; // 새로운 군집 발견
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int x, int y) {
        // 경계 체크
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return;
        }
        if(visited[x][y] || graph[x][y] ==0 ){
            return;
        }
        visited[x][y] =true;
        
        dfs(x + 1, y); // 아래
        dfs(x - 1, y); // 위
        dfs(x, y + 1); // 오른쪽
        dfs(x, y - 1); // 왼쪽
            
    }
}
