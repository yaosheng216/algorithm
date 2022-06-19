package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/19.
 */
public class LeetCode_206 {

    public ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
