package online.chenke;

/**
 * 单、双向链表反转
 */
public class CodeLinkedList {
    static class Node<T> {
        public T value;
        public Node<T> next;

        Node (T value){
            this.value = value;
        }
    }

    static class DoubleNode<T> {
        public T value;
        public DoubleNode<T> next;
        public DoubleNode<T> last;

        DoubleNode (T value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(22);
        Node<Integer> pre = head;

        DoubleNode<Integer> doubleHead = new DoubleNode<>(22);
        DoubleNode<Integer> doublePre = doubleHead;

        for (int i=0; i<10;i++){
            int val = (int) (i * (Math.random() * 10));
            Node<Integer> node = new Node<>(val);
            System.out.println(val);

            pre.next = node;
            pre = node;

            DoubleNode<Integer> doubleNode = new DoubleNode<>(val);
            doublePre.next = doubleNode;
            doublePre = doubleNode;
        }

        Node<Integer> revertList = singleLinkRevert(head);
        System.out.println(revertList);
        DoubleNode<Integer> doubleRevertList = doubleLinkRevert(doubleHead);
        System.out.println(doubleRevertList);
    }

    public static Node<Integer> singleLinkRevert(Node<Integer> head){
        Node<Integer> pre = null;
        Node<Integer> next = null;

        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static DoubleNode<Integer> doubleLinkRevert(DoubleNode<Integer> head){
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;

        while (head!=null){
            next = head.next;

            head.last = next;
            head.next = pre;

            pre = head;
            head = next;
        }

        return pre;
    }
}
