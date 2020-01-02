

public class quickSort {

    private static void quickSort(int[] a, int n) {
        quickSortInternal(a, 0, n - 1);
    }

    private static void quickSortInternal(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int c = partition(a, l, r);
        quickSortInternal(a, l, c - 1);
        quickSortInternal(a, c + 1, r);
    }


    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] > pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
    public static void main(String[] args) {
        int[] a = {4, 0, 1, 2, 2, 8, 9, 3, 5, 7};
        quickSort(a, a.length);
        for (int i: a) {
            System.out.print(i + " ,");
        }
    }
}
