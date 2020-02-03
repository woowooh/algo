public class SmallHeap extends Heap{
    public SmallHeap(int n) {
        super(n);
    }

    @Override
    protected void heapify(BinaryTree.Node[] a, int n, int i) {
        while (true) {
            int maxPos = i; // 标记是否发生了交换
            if (i * 2 <= n && a[i].data > a[i * 2].data) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos].data > a[i * 2 + 1].data) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) { // 未发生交换，到了合理位置
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    @Override
    public void insert(int data) {
        if (index >= n) {
            return;
        }
        index++;
        arr[index] = new BinaryTree.Node(data);
        int i = index;
        while (i / 2 > 0 && arr[i].data < arr[i / 2].data) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }
}
