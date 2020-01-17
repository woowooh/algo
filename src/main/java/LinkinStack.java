import java.util.LinkedList;

public class LinkinStack<T> {
    public LinkList.Node<T> top;

    public void push(T e) {
        LinkList.Node<T> n = new LinkList.Node<>();
        n.data = e;
        if (top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        } else {
            LinkList.Node<T> tmp = top;
            top = top.next;
            return tmp.data;
        }
    }

    public static void main(String[] args) {
        LinkinStack<Integer> l = new LinkinStack<>();
        l.push(1);
        System.out.println(l.top.data);
        l.push(2);
        System.out.println(l.top.data);
        l.push(3);
        l.push(3);
        System.out.println(l.top.data);
        l.pop();
        l.pop();
        System.out.println(l.top.data);
        l.push(4);
        System.out.println(l.top.data);
    }
}
