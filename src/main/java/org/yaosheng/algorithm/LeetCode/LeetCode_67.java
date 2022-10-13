package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/13.
 */
public class LeetCode_67 {

    public String addBinary(String a, String b) {

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        String result = "";
        int left = ca.length - 1;
        int right = cb.length - 1;
        char flag = '0';

        while (left >= 0 && right >= 0) {
            if (ca[left] + cb[right] + flag == 147) {
                flag = '1';
                result += "1";
            } else if (ca[left] + cb[right] + flag == 146) {
                flag = '1';
                result += "0";
            } else if (ca[left] + cb[right] + flag == 145) {
                flag = '0';
                result += "1";
            } else if (ca[left] + cb[right] + flag == 144) {
                flag = '0';
                result += "0";
            }
            left--;
            right--;
        }
        if (left > right) {
            while (left >= 0) {
                if (ca[left] + flag == 98) {
                    flag = '1';
                    result += "0";
                } else if (ca[left] + flag == 97) {
                    flag = '0';
                    result += "1";
                } else if (ca[left] + flag == 96) {
                    flag = '0';
                    result += "0";
                }
                left--;
            }
        }
        if (left < right) {
            while (right >= 0) {
                if (cb[right] + flag == 98) {
                    flag = '1';
                    result += "0";
                } else if (cb[right] + flag == 97) {
                    flag = '0';
                    result += "1";
                } else if (cb[right] + flag == 96) {
                    flag = '0';
                    result += "0";
                }
                right--;
            }
        }
        if (flag == '1') {
            result += "1";
        }
        return new StringBuffer(result).reverse().toString();
    }
}
