import java.io.*;
import java.util.*;

public class Main {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 집의 개수
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3]; 
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
                rgb[i][RED] = Integer.parseInt(st.nextToken());
                rgb[i][GREEN] = Integer.parseInt(st.nextToken());
                rgb[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            rgb[i][RED] = Math.min(rgb[i-1][GREEN],rgb[i-1][BLUE]) + rgb[i][RED];
            rgb[i][GREEN] = Math.min(rgb[i-1][RED],rgb[i-1][BLUE]) + rgb[i][GREEN];
            rgb[i][BLUE] = Math.min(rgb[i-1][GREEN],rgb[i-1][RED]) + rgb[i][BLUE];
            
        }
        System.out.println(Math.min(Math.min(rgb[N-1][RED],rgb[N-1][GREEN]),rgb[N-1][BLUE]));
    }
}