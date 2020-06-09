package online.chenke.leetcode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 使用两个指针，使用两个指针的距离差
 */
public class KthToLast {
    public static void main(String[] args) {
        RemoveDuplicateNodes.ListNode head = new RemoveDuplicateNodes.ListNode(1);
        RemoveDuplicateNodes.ListNode pre = head;
        int[] array = new int[]{1,2,3,2};
        for (int j = 0; j < array.length; j++) {
            pre.next = new RemoveDuplicateNodes.ListNode(array[j]);
            pre = pre.next;
        }

        System.out.println(kthToLast(head, 2));
    }

    public static int kthToLast(RemoveDuplicateNodes.ListNode head, int k) {
        RemoveDuplicateNodes.ListNode p = head;

        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        while (p!=null){
            p = p.next;
            head = head.next;
        }

        return head.val;
    }
}
