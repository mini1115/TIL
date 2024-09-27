import java.io.*;
import java.util.*;

public class Main {
        static class Country {
        int index;
        int gold;
        int silver;
        int bronze;

        public Country(int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        public int getIndex(){
            return this.index;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        // 국가의 수
        int N = Integer.parseInt(st.nextToken());
        // 알고 싶은 정답
        int target = Integer.parseInt(st.nextToken());
        // 정보 배열
        List<Country> countries = new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());;
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(i,gold,silver,bronze));
        }
        
        countries.sort((c1,c2)->{
            if(c1.gold != c2.gold){
                return c2.gold-c1.gold;
            } else if(c1.silver != c2.silver){
                return c2.silver - c1.silver;
            }else {
                return c2.bronze - c1.bronze;
            }
        });

        int rank =1;
       for (int i = 0; i < countries.size(); i++) {
            if (i > 0 && 
                countries.get(i).gold == countries.get(i - 1).gold &&
                countries.get(i).silver == countries.get(i - 1).silver &&
                countries.get(i).bronze == countries.get(i - 1).bronze) {
                // 이전 국가와 동일한 메달 수일 경우 같은 순위 유지
                continue;
            } else {
                rank = i + 1; // 순위 업데이트
            }
            if (countries.get(i).index == target) {
                System.out.println(rank);
                break;
            }
        }
    }

}