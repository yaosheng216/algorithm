package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/18.
 */
public class LeetCode_203_Dummy {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode (-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,5,6,4,7};
        ListNode head = new ListNode (nums);
        System.out.println (head);

        ListNode res = (new LeetCode_203_Dummy ()).removeElements (head,5);
        System.out.println (res);
    }
}
