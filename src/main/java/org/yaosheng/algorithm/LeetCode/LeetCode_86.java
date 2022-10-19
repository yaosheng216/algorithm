package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/19.
 */
public class LeetCode_86 {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode pre = new ListNode(0, head);
        ListNode ans = pre;
        while(pre.next !=null && pre.next.val < x){
            pre = pre.next;
        }

        // 要一个cur节点 cur去找x之后第一个小于x的节点
        ListNode cur = pre.next;
        while (cur!=null){
            // 主要依赖cur去遍历
            ListNode next = cur.next;
            if(next!=null && next.val<x){
                // 跳过小于x的节点
                cur.next = next.next;
                // 插入pre后面
                ListNode temp = pre.next;
                pre.next = new ListNode(next.val);
                pre.next.next = temp;
                pre = pre.next;
            }else{
                cur = cur.next;
            }
        }
        return ans.next;
    }
}
