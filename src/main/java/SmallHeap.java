public class SmallHeap extends Heap{
    public SmallHeap(int n) {
        super(n);
    }

    @Override
    public int compare(BinaryTree.Node n1, BinaryTree.Node n2) {
        return n2.data - n1.data;
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
