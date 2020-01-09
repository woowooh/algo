

public class NewLinkList<T> {
    public Node<T> first ;
    public Node<T> last;

    public static class Node<T> {
        public Node<T> preview;
        public T data;
        public Node<T> next;
    }

    public void insert(T element) {
        Node<T> n = new Node<>();
        n.data = element;
        if (first == null) {
            first = n;
            last = n;
        } else {
            first.preview = n;
            n.next = first;
            first = n;
        }
    }

    public void remove(int index) {
        Node<T> e = first;
        int n = 0;
        while (e != null) {
            if (n == index - 1) {
                e.next = e.next.next;
            }
            n++;
            e = e.next;
        }
    }

    public static void printList(NewLinkList<?> head) {
        Node<?> tmp = head.first;
        while (tmp != null) {
            if (tmp.preview != null) {
                System.out.println(tmp.preview.data);
            }
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void reverseList() {
        Node<T> q = first;
        Node<T> c = first.next;
        q.next = null;
        while (c != null) {
            Node<T> next = c.next;
            c.next = q;
            q = c;
            c = next;
        }
        first = q;
    }

    public static void main(String[] args) {
        int n = 10;
        NewLinkList<Integer> linkList = new NewLinkList<>();
        for (int i = 0; i < n; i++) {
            linkList.insert(i);
        }
//        printList(linkList);
        linkList.remove(3);
        printList(linkList);
        System.out.println();
//        linkList.reverseList();
//        printList(linkList);
    }
}
