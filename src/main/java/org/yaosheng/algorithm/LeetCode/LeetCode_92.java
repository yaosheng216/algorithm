package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/22.
 */
public class LeetCode_92 {

    public static class ListNode {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }

        head = pre.next;
        for(int i = left; i < right; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
