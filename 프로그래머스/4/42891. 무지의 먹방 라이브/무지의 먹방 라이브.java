import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        long total = Arrays.stream(food_times).mapToLong(i->i).sum();
        if(total<=k){
            return -1;
        }
    
        // (음식 시간, 음식 인덱스) 형태로 음식 목록을 생성
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{food_times[i], i + 1});
        }
        
        long sumValue = 0;  // 현재까지 소비된 시간
        long previous = 0;  // 이전 음식 시간
        int len = n;  // 남은 음식의 개수

        // 음식 시간이 모두 동일할 때까지 소모
       while( (sumValue + (pq.peek()[0] - previous)*n ) <=k){
           long now = pq.poll()[0];
           sumValue += (now - previous) *n;
           n--;
           previous = now;
       }

        // 남은 음식을 리스트에 저장
        List<long[]> remainingFoods = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingFoods.add(pq.poll());
        }

        // 남은 음식들을 인덱스 순으로 정렬
        Collections.sort(remainingFoods, (a, b) -> Long.compare(a[1], b[1]));

        // 마지막 남은 시간에 해당하는 음식을 계산
        int index = (int) ((k - sumValue) % n);
        return (int) remainingFoods.get(index)[1];
    }
}
