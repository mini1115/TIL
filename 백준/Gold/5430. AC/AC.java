import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // 테스트 케이스 ex) 4
        int T = Integer.parseInt(st.nextToken());
        while(T-- >0){
            // 연산 입력 ex)RDD
            String command = br.readLine();
            // 길이 N  ex)4
            int N = Integer.parseInt(br.readLine());

            // 양방향으로 제거를 위한 deque 선언
            Deque<Integer> deque = new ArrayDeque<>();
            // 정보 입력 [1,2,3,4]
            String input  = br.readLine();
            input = input.replaceAll("[\\[\\] ]", ""); // 대괄호와 공백 제거
            String[] strNumbers = input.split(","); // 콤마로 분리
            for (String strNumber : strNumbers) {
                if (!strNumber.isEmpty()) {
                deque.add(Integer.parseInt(strNumber));
                }
            }
            System.out.println(ac(deque,command));
        }
    }
    static String ac(Deque<Integer> arr, String command){
        boolean flag = false;
        //연산 수행 ex)RDD
        for(char c :command.toCharArray()){
            if(c == 'R' ){
                flag = !flag;
            }else if(c == 'D'){
            // Drop 수행
            // queue 배열이 비어있을경우
                if(arr.isEmpty()){
                    return "error";
                }
                if(flag){
                        //역순의 경우 뒤에서 빼준다.
                        arr.pollLast();
                }else{
                        //역순이 아닐경우 앞에서 뺴준다.
                        arr.poll();
                }
            }
        } // 연산 for문
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!arr.isEmpty()){
            sb.append(flag? arr.removeLast() : arr.removeFirst()).append(',');
        }
        // 마지막 ' , ' 를 제거하기 위함
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        
        return sb.toString();      
    }
}