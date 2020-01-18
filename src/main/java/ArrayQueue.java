

public class ArrayQueue<E> {
    private int DEFAULT_CAPACITY = 10;
    int head = 0;
    int tail = 0;
    Object[] arr = new Object[DEFAULT_CAPACITY];


    public void enqueue(E e) {
        arr[tail++] = e;
    }

    public E dequeue() {
        E e = (E)arr[head++];
        return e;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
