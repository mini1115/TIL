class Solution {
    public int solution(int[] wallet, int[] bill) {
        // 지폐를 접은 횟수
        int answer = 0;
        while(true){
            if(check(wallet,bill)){
                break;
            }
            bill = cross(bill);
            if(check(wallet,bill)){
                break;
            }
            bill = fold(bill);
            answer++;
        }
        return answer;
    }
    public int[] fold(int[] data){
        if(data[0]>data[1]){
            data[0] = data[0] /2;
        }else{
            data[1] = data[1] /2;
        }
        return data;
    }
    public int[] cross(int[] data){
        int[] new_data = new int[data.length];
        new_data[0] = data[1];
        new_data[1] = data[0];
        
        return new_data;
    }
    public boolean check(int[] data1, int[] data2){
        if(data1[0] >= data2[0]){
            if(data1[1] >= data2[1]){
                return true;
            }
        }
        return false;
    }
}