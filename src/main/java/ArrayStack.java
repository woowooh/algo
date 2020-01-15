import java.util.ArrayList;
import java.util.Stack;


public class ArrayStack<E> {
    public ArrayStack() {
        element = new Object[10];
    }
    int eleCount;
    Object[] element;

    int size() {
        return eleCount;
    }

    void push(E e) {
        element[eleCount++] = e;
    }

    E pop() {
        E r = (E)element[--eleCount];
        element[eleCount] = null;
        return r;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> as = new ArrayStack<>();
        as.push(1);
        as.push(1);
        as.pop();
        as.push(2);
        as.push(1);
        as.pop();
        as.push(3);
        for (int i = 0 ; i < as.element.length; i++) {
            System.out.print(as.element[i] + ", ");
        }
    }
}
