package cn.link.acleetcode.c21;

/**
 * 题目：合并两个有序链表
 * 描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2!=null) return l2;
        if(l2 == null && l1!=null) return l1;

        ListNode head = new ListNode(0);
        ListNode index = head;

        while(l1 != null && l2 != null){

            if(l1.val <= l2.val){
                index.next = l1;
                l1 = l1.next;
            }else{
                index.next = l2;
                l2 = l2.next;
            }

            index = index.next;
        }

        if(l1 != null){
            index.next = l1;
        }

        if(l2 != null){
            index.next = l2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l2.next, l1);
            return l2;
        }
    }


}

