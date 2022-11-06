package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/11/6.
 */
public class LeetCode_1678 {

    public static String interpret(String command) {

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < command.length()){
            char c = command.charAt(i);
            if(c == 'G'){
                sb.append('G');
                i ++;
                continue;
            }
            char next = command.charAt(i + 1);
            if(next == ')'){
                sb.append('o');
                i += 2;
            }else{
                sb.append('a').append('l');
                i += 4;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println (interpret ("G()(al)"));
    }
}
