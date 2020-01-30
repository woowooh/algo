


public class LoopQueue<E> {
    private int DEFAULT_CAPACITY = 10;
    int head = 0;
    int tail = 0;
    Object[] arr = new Object[DEFAULT_CAPACITY];

    public boolean enqueue(E e) {
        if ((tail + 1) % DEFAULT_CAPACITY == head) return false;
        arr[tail] = e;
        tail = (tail + 1) % DEFAULT_CAPACITY;
        return true;
    }

    public E dequeue() {
        if (head == tail) return null;
        E ret = (E)arr[head];
        head = (head + 1) % DEFAULT_CAPACITY;
        return ret;
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
