import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> deque = new LinkedList<Integer>();
        
        for(int i=0;i<progresses.length;i++){
            progresses[i] = 100 - progresses[i];

            double data =  (double)progresses[i] / speeds[i];
            deque.add((int)Math.ceil(data));
        }
        
        while(!deque.isEmpty()){
            boolean flag = true;
            int time = 1;
            int now = deque.poll();
            
            while(flag && !deque.isEmpty()){
                int next = deque.peek();
                
                if(now>=next){
                    deque.poll();
                    time++;
                }else{
                    flag=false;
                }
            }
            
            answer.add(time);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}