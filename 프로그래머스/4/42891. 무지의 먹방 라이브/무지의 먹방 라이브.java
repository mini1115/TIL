import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        Long total = Arrays.stream(food_times).mapToLong(i->i).sum();
        if(total <= k ) {
            return -1;
        }
        
        int N = food_times.length;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        
        for(int i=0;i<N;i++){
            pq.offer(new long[]{food_times[i],i+1});
        }
        
        long sumValue = 0;
        long previous = 0;
        
        while( (sumValue + (pq.peek()[0]-previous)*N) <= k){
            long now = pq.poll()[0];
            sumValue += (now-previous)*N;
            N--;
            previous = now;
        }
        
        List<long[]> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        
        Collections.sort(result,(a,b)->Long.compare(a[1],b[1]));
        
        int index = (int)((k-sumValue) % N);
        
        return (int)result.get(index)[1];
        
    }
}