import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] triangle) {
        // int answer = 0;
        // return answer;
        int N = triangle.length;
        int[][] result = new int[N][N];
        // Top-down
        for(int i=1;i<N;i++){
            for(int j=0;j<triangle[i].length;j++){
                // 처음지점
                if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                    continue;
                }
                // 끝지점
                if(j==triangle[i].length-1){
                   triangle[i][j] +=triangle[i-1][j-1]; 
                    continue;
                }
                int data =  triangle[i][j] + triangle[i-1][j-1];
                int data2 = triangle[i][j] + triangle[i-1][j];
                triangle[i][j] = Math.max(data,data2);
            }           
        }
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<triangle[i].length;j++){
        //         System.out.print(triangle[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return Arrays.stream(triangle[triangle.length-1]).max().orElseThrow();
    }
}