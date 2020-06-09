package online.chenke.leetcode;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * 将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点。
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public static void deleteNode(RemoveDuplicateNodes.ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
