package cn.link.acleetcode.c23;

import com.sun.istack.internal.localization.NullLocalizable;

/**
 * 题目：合并K个排序链表
 * 描述：合并 k 个排序链表，返回合并后的排序链表。
 */
public class Solution {

    class ListNode {
        int val;
       ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //顺序合并
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        int len = lists.length;
        if(len ==1) return lists[0];
        ListNode mergeTmp=null;
        for(int i=0; i<len; i++){
             mergeTmp = mergeTwoLists(lists[i], mergeTmp);
        }
        return mergeTmp;
    }

    //分治
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeHelper(lists, 0, lists.length-1);
    }

    public ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start > end) return null;
        if(start == end) return lists[start];

        int mid = start + (end-start)/2;//防止加法溢出

        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid+1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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

}
