

public class Heap {
    protected BinaryTree.Node[] arr;
    protected int n;
    protected int index;

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

    public void insert(BinaryTree.Node data) {
        if (index >= n) return;
        index++;
        arr[index] = data;
        int i = index;
        while (i / 2 > 0 && arr[i].data > arr[i / 2].data) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    public BinaryTree.Node removeTop() {
        if (index == 0) {
            return null;
        }
        BinaryTree.Node tmp = arr[1];
        arr[1] = arr[index];
        index--;
        heapify(arr, index, 1);
        return tmp;
    }

    protected void heapify(BinaryTree.Node[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i].data < a[i * 2].data) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos].data < a[i * 2 + 1].data) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static void swap(BinaryTree.Node[] arr, int src, int des) {
        BinaryTree.Node tmp = arr[src];
        arr[src] = arr[des];
        arr[des] = tmp;
    }

    public static Heap buildHeap(BinaryTree.Node[] arr) {
        Heap heap = new Heap(arr.length);
        BinaryTree.Node[] heapArr = new BinaryTree.Node[arr.length + 1];
        System.arraycopy(arr, 0, heapArr, 1, arr.length);
        heap.arr = heapArr;
        heap.index = arr.length;
        int n = arr.length;
        for (int i = n / 2; i >= 1; i--) {
            heap.heapify(heap.arr, n, i);
        }
        return heap;
    }

    public static Heap heapSort(BinaryTree.Node[] arr) {
        Heap heap = buildHeap(arr);
        int n = arr.length;
        int k = n;
        while (k > 1) {
            swap(heap.arr, k, 1);
            k--;
            heap.heapify(heap.arr, k, 1);
        }
        return heap;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        Heap smallHeap = new SmallHeap(10);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
            smallHeap.insert(i);
        }
//        BinaryTree.printByLayer(heap);
//        for (int i = 0; i < 8; i++) {
//            heap.removeTop();
//            BinaryTree.printByLayer(heap);
//        }
//        heap.removeTop();
//        BinaryTree.printByLayer(heap);
//        BinaryTree.printByLayer(smallHeap);
//        smallHeap.removeTop();
        BinaryTree.printByLayer(smallHeap);
//        int size = 10;
//        BinaryTree.Node[] arr = new BinaryTree.Node[size];
//        for (int i = 0; i < size; i++) {
//            BinaryTree.Node n = new BinaryTree.Node(i);
//            arr[i] = n;
//        }
//        Heap heap = buildHeap(arr);
//        Heap heap = heapSort(arr);
//        BinaryTree.printByLayer(heap);
    }
}
