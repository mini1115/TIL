import java.io.*;
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int data : arr){
            if(stack.size()==0){
                stack.push(data);
            }else{
                int check = stack.peek();
                if(check==data){
                    continue;
                }else{
                    stack.push(data);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(stack);
        // Collections.reverse(list);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}