import java.io.*;
import java.util.*;

public class Main {
    
     static class Country{
        int index;
        int gold;
        int silver;
        int bronze;
        int rate;
        
        public Country(int index,int gold,int silver,int bronze,int rank){
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }
    }
    
    public static void main(String args[]) throws IOException {
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        // Number
        int N = Integer.parseInt(st.nextToken());
        // targetNumber
        int M = Integer.parseInt(st.nextToken());
        
        List<Country> countries = new ArrayList<>();
        
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(index,gold,silver,bronze,0));
        }
        // 정렬렬
        countries.sort((c1,c2)->{
            if(c1.gold==c2.gold){
                if(c1.silver==c2.silver){
                    return c2.bronze - c1.bronze;
                }else{
                    return c2.silver - c1.silver;
                }
            }else{
                return c2.gold - c1.gold;
            }
        });
        
        countries.get(0).rate = 1;
        

        for(int i=1;i<N;i++){
            Country country = countries.get(i);
            if(countries.get(i).index == M){
                answer = i;
            }
            if(country.gold == countries.get(i-1).gold &&
            country.silver == countries.get(i-1).silver &&
            country.bronze == countries.get(i-1).bronze){
                countries.get(i).rate = countries.get(i-1).rate;
            }
            else{
                countries.get(i).rate = i+1;
            }
        }
        System.out.println(countries.get(answer).rate);
    }
}
