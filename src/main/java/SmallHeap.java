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

    @Override
    public void insert(BinaryTree.Node data) {
        if (index >= n) return;
        index++;
        arr[index] = data;
        int i = index;
        while (i / 2 > 0 && arr[i].data < arr[i / 2].data) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    public static void main(String[] args) {
        Heap smallHeap = new SmallHeap(3);
        BinaryTree.Node[] arr1 = {new BinaryTree.Node(1), new BinaryTree.Node(2), new BinaryTree.Node(3)};
        BinaryTree.Node[] arr2 = {new BinaryTree.Node(2), new BinaryTree.Node(4), new BinaryTree.Node(6)};
        BinaryTree.Node[] arr3 = {new BinaryTree.Node(0), new BinaryTree.Node(3), new BinaryTree.Node(5)};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i].flag = 1;
            arr2[i].flag = 2;
            arr3[i].flag = 3;
        }
        int[] result = new int[9];
        smallHeap.insert(arr1[0]);
        smallHeap.insert(arr2[0]);
        smallHeap.insert(arr3[0]);
        int n = 1, j = 1, k = 1;
        int i = 0;
        for (; i < 9; i++) {
            BinaryTree.Node node = null;
            BinaryTree.Node d = smallHeap.removeTop();
            if (d.flag == 1 && n < 3) {
                node = arr1[n];
                n++;
            } else if (d.flag == 2 && j < 3) {
                node = arr2[j];
                j++;
            } else if (d.flag == 3 && k < 3)  {
                node = arr3[k];
                k++;
            }
            result[i] = d.data;
            if (node != null) {
                smallHeap.insert(node);
            }
        }
        for (int e : result) {
            System.out.print(e + ", ");
        }
    }
}
