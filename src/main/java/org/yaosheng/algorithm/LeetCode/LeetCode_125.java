package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/11/3.
 */
public class LeetCode_125 {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int left = 0,right = s.length() - 1;

        while (left < right){
            while(left < right &&! Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            while(left < right &&! Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
