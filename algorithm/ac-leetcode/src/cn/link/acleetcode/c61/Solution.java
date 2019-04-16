package cn.link.acleetcode.c61;

public class Solution {


    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;

        int len = 1;
        ListNode p = head;
        while(p.next!=null){
            len++;
            p = p.next;
        }
        p.next = head;

        int mod = k % len;

        if(mod == 0) {
            p.next = null;
            return head;
        }

        p = head;
        ListNode tmp = p;
        for(int i=0 ; i<len-mod; i++){
            tmp = p;
            p = p.next;
        }

        tmp.next=null;

        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode listNode = solution.rotateRight(l1, 1);
        while(listNode!=null){
            System.out.println(listNode);
            listNode = listNode.next;
        }

    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}