package org.yaosheng.algorithm.SegmentTree;

/**
 * Created by yaosheng on 2022/7/24.
 */
public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree = new SegmentTree<> (nums, (a,b) -> a + b);
        System.out.println (segTree);
    }
}
