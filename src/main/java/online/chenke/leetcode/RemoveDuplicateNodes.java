package online.chenke.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pre = head;
        int[] array = new int[]{1,1,1,2};
        for (int j = 0; j < array.length; j++) {
            pre.next = new ListNode(array[j]);
            pre = pre.next;
        }

        removeDuplicateNodes(head);

        System.out.println(head);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head==null || head.next==null){
           return head;
        }

        Set<Integer> sets = new HashSet();
        ListNode p = head;
        ListNode newHead = new ListNode(-1);
        ListNode p1 = newHead;

        while (p!=null){
            if(!sets.contains(p.val)){
                sets.add(p.val);

                p1.next = p;
                p1 = p1.next;
            }

            p = p.next;
        }

        p1.next=null;

        return newHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
