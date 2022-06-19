package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/19.
 * 使用递归实现反转链表
 */
public class LeetCode_206_Recursion {

    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null)
            return head;
        ListNode rev = reverseList (head.next);
        head.next.next = head;
        head.next = null;

        return rev;
    }
}
