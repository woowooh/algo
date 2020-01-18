

public class Browser<T> {
    LinkinStack<T> preview = new LinkinStack<>();
    LinkinStack<T> history = new LinkinStack<>();
    T current;

    public T goForward() {
        T e = preview.pop();
        goPage(e);
        history.push(e);
        return e;
    }

    public T backward() {
        T e = history.pop();
        goPage(e);
        preview.push(current);
        current = e;
        return e;
    }

    public void viewPage(T e) {
        if (current != null) {
            history.push(current);
        }
        current = e;
    }

    public void goPage(T p) {

    }

    public static void main(String[] args) {
        Browser<Integer> b = new Browser<>();
        b.viewPage(1);
        b.viewPage(2);
        b.viewPage(3);
        b.viewPage(4);
        System.out.println(b.backward());
        System.out.println(b.backward());
        System.out.println(b.goForward());
        System.out.println(b.goForward());
    }
}
