

public class LinkinQueue<E> {
    LinkList.Node<E> head;
    LinkList.Node<E> tail;

    public void enqueue(E e) {
        if (tail == null) {
            LinkList.Node<E> n = new LinkList.Node<>();
            n.data = e;
            tail = n;
            head = tail;
            return;
        }
        LinkList.Node<E> n = new LinkList.Node<>();
        n.data = e;
        tail.next = n;
        tail = n;
    }

    public E dequeue() {
        if (head == null) {
            return null;
        }
        LinkList.Node<E> n = head;
        head = head.next;
        return n.data;
    }

    public static void main(String[] args) {
        LinkinQueue<Integer> lq = new LinkinQueue<>();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        lq.enqueue(4);
        lq.enqueue(5);
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        lq.enqueue(6);
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
    }
}
