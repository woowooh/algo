import java.util.LinkedList;

public class MergeLinkList {
    public static void merge(LinkList<Integer> l1, LinkList<Integer> l2) {
        LinkList<Integer> ll = new LinkList<>();
        ll.first = new LinkList.Node<>();
        LinkList.Node<Integer> first = ll.first;
        LinkList.Node<Integer> begin = first;
        LinkList.Node<Integer> l1Head = l1.first;
        LinkList.Node<Integer> l2Head = l2.first;
        while (l1Head != null && l2Head != null) {
            if (l1Head.data > l2Head.data) {
                LinkList.Node<Integer> n = new LinkList.Node<>();
                n.data = l1Head.data;
                first.next = n;
                first = n;
                l1Head = l1Head.next;
            } else {
                LinkList.Node<Integer> n = new LinkList.Node<>();
                n.data = l2Head.data;
                first.next = n;
                first = n;
                l2Head = l2Head.next;
            }
        }
        while (l1Head != null) {
            LinkList.Node<Integer> n = new LinkList.Node<>();
            n.data = l1Head.data;
            first.next = n;
            first = n;
            l1Head = l1Head.next;
        }
        while (l2Head != null) {
            LinkList.Node<Integer> n = new LinkList.Node<>();
            n.data = l2Head.data;
            first.next = n;
            first = n;
            l2Head = l2Head.next;
        }
        ll.first = begin;
        LinkList.printList(ll);
    }


    public static void main(String[] args) {
        int n = 10;
        LinkList<Integer> l1 = new LinkList<>();
        for (int i = 0; i < n; i++) {
            l1.insert(i);
        }
        LinkList<Integer> l2 = new LinkList<>();
        for (int i = 0; i < n; i++) {
            l2.insert(i);
        }
        merge(l1, l2);
    }
}
