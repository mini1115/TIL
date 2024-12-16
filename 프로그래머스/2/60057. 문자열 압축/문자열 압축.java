import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int num = s.length();
        
        for(int step =1; step<=num/2;step++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,step);
            int count = 1;
            for(int i=step;i<=num;i+=step){
                String now;
                if(step+i <= num){
                    now = s.substring(i,step+i);
                }else{
                    now = s.substring(i);
                }
                if(now.equals(prev)){
                    count++;
                }else{
                    sb.append(count>1 ? count+prev : prev);
                    prev = now;
                    count = 1;
                }
            }
            sb.append(count>1 ? count+prev : prev);
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}