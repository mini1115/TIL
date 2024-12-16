class Solution {
    static int N;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = key.length;
        int M = lock.length;
        //새로운 lock만들기 약 3배 크기
        int[][] new_lock = new int[M*3][M*3];
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                new_lock[i+M][j+M]=lock[i][j];
            }
        }
        
        for(int rotation=0;rotation<4;rotation++){
            key=rotate(key);
            for(int x=0;x<M*2;x++){
                for(int y=0;y<M*2;y++){
                    for(int i=0;i<N;i++){
                        for(int j=0;j<N;j++){
                            new_lock[x+i][y+j] +=key[i][j];
                        }
                    }
                    if(check(new_lock)){
                        return true;
                    }
                    else{
                        for(int i=0;i<N;i++){
                            for(int j=0;j<N;j++){
                                new_lock[x+i][y+j] -= key[i][j];
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    static boolean check(int[][] new_lock){
        int ll = new_lock.length/3;
        for(int i=ll;i<ll*2;i++){
            for(int j=ll;j<ll*2;j++){
                if(new_lock[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    static int[][] rotate(int[][] key){
        int[][] new_key = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                new_key[j][N-i-1] = key[i][j];
            }
        }
        return new_key;
    }
}