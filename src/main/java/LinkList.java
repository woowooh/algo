public class LinkList {

    public static class Node<T> {
        public Node preview;
        public T data;
        public Node next;
    }

    public static Node<Integer> creatList(int n) {
        Node<Integer> head = new Node<>();
        head.data = null;
        for (int i = 0; i < n; i++) {
            Node<Integer> node = new Node<>();
            node.data = i;
            node.next = head.next;
            head.next = node;
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void reverseList(Node<Integer> head) {
        Node<Integer> q = null;
        Node<Integer> c = head;
        while (c != null) {
            Node<Integer> next = c.next;
            c.next = q;
            q = c;
            c = next;
        }
        printList(q);
    }

    public static void main(String[] args) {
        int n = 10;
        Node<Integer> list = creatList(n);
        printList(list);
        System.out.println();
        reverseList(list);
    }
}
