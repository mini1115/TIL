import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
// 속한 노래가 많이 재생된 장르를 먼저 수록
// 장르내에서 많이 재생된 노래
// 장르내에서 고유번호가 낮은 노래 먼저 수록  
        Map <String,Integer> info = new HashMap<>();
        Map<String,HashMap<Integer,Integer>> music = new HashMap<>();
        
        for(int i=0;i<plays.length;i++){
            if(!info.containsKey(genres[i])){
                // 존재하지 않는다면
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(i,plays[i]);
                music.put(genres[i],map);
                info.put(genres[i],plays[i]);
                
            }else{
                // 존재한다면
                int num = info.get(genres[i])+plays[i];
                info.put(genres[i],num);
                music.get(genres[i]).put(i,plays[i]);
            }
        }
        List<String> keySet = new ArrayList(info.keySet());
        Collections.sort(keySet ,(s1,s2) ->  info.get(s2) - info.get(s1));
        // 순차적 정렬 -> Treemap(reverse) 내림차순
        for(String key: keySet){
            //<Integer,Integer> map -> index, plays[i]
            HashMap<Integer,Integer> map = music.get(key);
            // map.keySet() -> index 반환
            List<Integer> genres_key = new ArrayList(map.keySet());
            // plays[i] 횟수로 내림차순 정렬
            Collections.sort(genres_key,(s1,s2)->map.get(s2)-map.get(s1));
            
            answer.add(genres_key.get(0));
            // 장르의 노래가 2개 이상일 경우
            if(genres_key.size()>1){
                answer.add(genres_key.get(1));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}