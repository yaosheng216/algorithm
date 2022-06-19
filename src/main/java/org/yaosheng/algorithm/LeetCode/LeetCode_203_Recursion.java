package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/19.
 */
public class LeetCode_203_Recursion {

    public ListNode removeElements(ListNode head,int val){

        if(head == null)
            return null;

        ListNode res = removeElements (head.next,val);
        if(head.val == val)
            return res;
        else{
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};
        ListNode head = new ListNode (nums);
        System.out.println (head);

        ListNode res = (new LeetCode_203_Recursion()).removeElements (head,6);
        System.out.println (res);
    }
}
