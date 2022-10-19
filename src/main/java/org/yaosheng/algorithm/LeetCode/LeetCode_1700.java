package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/19.
 */
public class LeetCode_1700 {

    public int countStudents(int[] students, int[] sandwiches) {

        int let0 = 0,let1 = 0;
        for(int i : students){
            if(i == 0) {
                let0 ++;
            }else {
                let1 ++;
            }
        }
        for(int i : sandwiches){
            if(i == 0) {
                if(let0 == 0) break;
                let0 --;
            }else{
                if(let1 == 0) break;
                let1 --;
            }
        }
        return let0 + let1;
    }
}
