import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // Arrays.sort(stages);
        
        int[] stage_data = new int[N];
        int total = stages.length;
        
        for(int temp: stages){
            if(temp-1>=N){
                continue;
            }
            stage_data[temp-1] = stage_data[temp-1] + 1;
        }
        
        //  인덱스 ,실패율     
        Double [][] result = new Double[N][2];
        
        // for(int i=0;i<N;i++){
        //     Double fail = (double)stage_data[i] / total;
        //     total -= stage_data[i];
        //     result.put(fail,i+1);
        // }
        
        for(int i=0;i<N;i++){
            // System.out.println(total+"&"+stage_data[i]);
            Double fail = (double)stage_data[i] / total;
            // System.out.println("fail"+ fail) ; 
            total -= stage_data[i];
            result[i][0] =  (double)i+1;
            result[i][1] = fail;
        }
        // for (Map.Entry<Double,Integer> entry : result.entrySet()) {
        //     System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        // }
        
        Arrays.sort(result, (o1, o2) -> {
            if (Double.isNaN(o1[1]) && Double.isNaN(o2[1])) return 0; // 둘 다 NaN이면 그대로
            if (Double.isNaN(o1[1])) return 1; // o1이 NaN이면 뒤로 보냄
            if (Double.isNaN(o2[1])) return -1; // o2가 NaN이면 뒤로 보냄
            return Double.compare(o2[1], o1[1]); // 일반적인 내림차순 비교
        });
        
        for(int i=0;i<N;i++){
            System.out.println(result[i][0] + " &&&" + result[i][1]);
        }
        int index = 0;
        for( Double[] temp : result){
            answer[index++] = (int)temp[0].doubleValue();;
        }
        return answer;
    }
}