import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[] data = new int[N+2];
        for(int i=1;i<=N;i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        
        int[] score = new int[N+2];
        score[1] = data[1];
        score[2] = data[1] + data[2];
        for(int i=3;i<=N;i++){
            score[i] = Math.max(score[i-3]+data[i-1],score[i-2])+data[i];
        }
        System.out.println(score[N]);
    }
}