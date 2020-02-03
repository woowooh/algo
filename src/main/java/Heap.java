

public class Heap {
    public BinaryTree.Node[] arr;
    private int n;
    public int index;

    public Heap(int capacity) {
        arr = new BinaryTree.Node[capacity + 1];
        n = capacity;
        index = 0;
    }

    public void insert(int data) {
        if (index >= n) return;
        index++;
        arr[index] = new BinaryTree.Node(data);
        int i = index;
        while (i / 2 > 0 && arr[i].data > arr[i / 2].data) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (index == 0) {
            return;
        }
        arr[1] = arr[index];
        index--;
        heapify(arr, index, 1);
    }

    private void heapify(BinaryTree.Node[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i].data < a[i * 2].data) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos].data < a[i * 2 + 1].data) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public void swap(BinaryTree.Node[] arr, int src, int des) {
        BinaryTree.Node tmp = arr[src];
        arr[src] = arr[des];
        arr[des] = tmp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        BinaryTree.printByLayer(heap);
        heap.removeMax();
        BinaryTree.printByLayer(heap);
    }
}
