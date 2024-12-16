import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        // 확장한 Lock을 만든다.
        int N = lock.length;
        int M = key.length;
        
        int newLockLength = N*3;
        int[][] new_Lock = new int[newLockLength][newLockLength];
        
        for(int i=N;i<N*2;i++){
            for(int j=N;j<N*2;j++){
                new_Lock[i][j] = lock[i-N][j-N];
            }
        }
        
//         for(int i=0;i<newLockLength;i++){
//             for(int j=0;j<newLockLength;j++){
//                 System.out.print(new_Lock[i][j]);
//             }
//             System.out.println();
//         }
        // 4방향 회전
        for(int r=0;r<4;r++){
            key = rotate(key);
            
            for(int x=0;x<N*2;x++){
                for(int y=0;y<N*2;y++){
                    for(int i=0;i<M;i++){
                        for(int j=0;j<M;j++){
                            new_Lock[x+i][y+j] += key[i][j];
                        }
                    }
                    if(check(new_Lock)){
                        return true;
                    }
                    else{
                        for(int i=0;i<M;i++){
                            for(int j=0;j<M;j++){
                            new_Lock[x+i][y+j] -= key[i][j];
                            }
                        }
                    }
                }
            }
        }
        
        
        
        return answer;
    }
    
    public boolean check(int[][] lock){
        int len = lock.length /3;
        for(int i=len;i<len*2;i++){
            for(int j=len;j<len*2;j++){
                if(lock[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] rotate(int[][] key){
        int len = key.length;
        int[][] new_key = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                new_key[j][len-i-1]= key[i][j];
            }
        }
        return new_key;
    }
}