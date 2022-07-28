package org.yaosheng.algorithm.UnionFind;

/**
 * Created by yaosheng on 2022/7/28.
 */
public interface UF {

    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
