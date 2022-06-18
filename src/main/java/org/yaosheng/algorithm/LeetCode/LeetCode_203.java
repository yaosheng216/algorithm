package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/18.
 */
public class LeetCode_203 {

    class ListNode {

        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}
