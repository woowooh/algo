

public class ArrayQueue<E> {
    private int DEFAULT_CAPACITY = 10;
    int head = 0;
    int tail = 0;
    Object[] arr = new Object[DEFAULT_CAPACITY];


    public void enqueue(E e) {
        if (tail == (DEFAULT_CAPACITY)) {
            if (head == 0) {
                return;
            }
            int i = 0;
            for (; i < tail - head; i++) {
                arr[i] = arr[i + head];
            }
            while (i < DEFAULT_CAPACITY) {
                arr[i] = null;
                i++;
            }
            tail -= head;
            head = 0;
        }
        arr[tail++] = e;
    }

    public E dequeue() {
        E e = (E)arr[head];
        arr[head] = null;
        head++;
        return e;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        for (Object f: q.arr) {
            System.out.print((Integer)f + ", ") ;
        }
        System.out.println();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        for (Object f: q.arr) {
            System.out.print((Integer)f + ", ") ;
        }
        System.out.println();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(10);
        q.enqueue(11);
        for (Object f: q.arr) {
            System.out.print((Integer)f + ", ") ;
        }
    }
}
