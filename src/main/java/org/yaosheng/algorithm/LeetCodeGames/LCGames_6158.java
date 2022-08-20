package org.yaosheng.algorithm.LeetCodeGames;

/**
 * Created by yaosheng on 2022/8/21.
 */
public class LCGames_6158 {

    public static String shiftingLetters(String s, int[][] shifts){

        char[] table = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'};

        char[] c = s.toCharArray ();
        for(int i = 0;i < shifts.length;i ++){

            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];

            for(int j = start;j <= end;j ++){
                if(dir == 1){
                    int m = c[j] - 95;
                    if(m == 27)
                        m = 1;
                    c[j] = table[m];
                }else{
                    int n = c[j] - 97;
                    if(n == 0)
                        n = 26;
                    c[j] = table[n];
                }
            }
        }
        return new String (c);
    }

    public static void main(String[] args) {

        int[][] arr = {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println (shiftingLetters ("abc",arr));
    }
}
