package org.yaosheng.algorithm.SegmentTree;

/**
 * Created by yaosheng on 2022/7/24.
 */
public interface Merger<E> {

    E merge(E a,E b);
}
