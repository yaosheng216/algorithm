package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/21.
 */
public class LeetCode_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[k --] = nums2[j --];
            } else {
                nums1[k --] = nums1[i --];
            }
        }
    }
}
