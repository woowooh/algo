import java.util.LinkedHashMap;
import java.util.Map;

public class LinkList {

    public static class Node<T> {
        public Node preview;
        public T data;
        public Node next;
    }

    static Node createList(int n) {
        Node head = new Node();
        Node node;
        head.data = null;
        for (int i = 0; i < n; i++) {
            node = new Node();
            node.data = i;
            node.next = head.next;
            head.next = node;
        }
        return head;
    }

    static Node createList() {
        Character[] arrs = {'a', 's', 'd', 'f', 'g', 'g', 'f', 'd', 's', 'a'};
        Node head = new Node<Character>();
        Node node = new Node();
        head.data = null;
        head.preview = null;
        for (int i = 0; i < arrs.length; i++) {
            node = new Node();
            node.data = arrs[i];
            node.next = head.next;
            head.next = node;
        }
        return head;
    }

    static Node jumpToEnd(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    static void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            System.out.print(", ");
            node = node.next;
        }
        System.out.println();
    }

    static Node reverseList(Node head) {
        Node q = head;
        Node current = q.next;
        q.next = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = q;
            q = current;
            current = next;
        }
        return q;
    }

//    static Node LruImpl() {
//        Node head = createList(12);
//
//    }

    public static void main(String[] args) {
        Node head = createList();
        printList(head);
        Node n = new Node();
        head.preview = null;
        Node current = head;
        for (int i = 0;i < 10; i++) {
            n = new Node();
            Node next = current.next;
            next.preview = current;
            current = next;
        }
        isPalindrome(head);
//        Node h = jumpToEnd(head);
//        while (h.preview != null) {
//            System.out.println(h.data);
//            h = h.preview;
//        }
//        System.out.println(h.data);

    }

    public static Boolean isPalindrome(Node head) {
        Node low = head;
        Node fast = head;
        if (low != null) {
            if (low.next == null) {
                return low.data == head.next.next.data;
            } else {
                while (fast != null && fast.next != null) {
                    low = low.next;
                    fast = fast.next.next;
                }
            }
        }
        Node mid = low;
        mid = mid.next;
        while (low.preview != null) {
            System.out.print(low.data);
            System.out.print(mid.data);
            System.out.println();
            low = low.preview;
            mid = mid.next;
        }
        return true;
    }
    Map l = new LinkedHashMap();
}
