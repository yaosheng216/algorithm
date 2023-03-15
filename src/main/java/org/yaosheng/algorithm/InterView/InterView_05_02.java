package org.yaosheng.algorithm.InterView;

/**
 * Created by yaosheng on 2023/3/2.
 */
public class InterView_05_02 {

    public static String printBin(double num) {

        double[] t = new double[] {0.5,0.25,0.125,0.0625,0.03125,0.015625,0.0078125,0.00390625};
        StringBuilder res = new StringBuilder("0.");
        for (int i = 0;i < t.length && num != 0;i ++) {
            if (num >= t[i]) {
                res.append("1");
                num -= t[i];
            } else if (num < t[i]) {
                res.append("0");
            }
        }
        return num == 0 ? res.toString() : "ERROR";
    }

    public static void main(String[] args) {
        System.out.println (printBin (0.80));
    }
}
