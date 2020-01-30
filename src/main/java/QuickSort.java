

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }

    public static void quickSortInternal(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int p = povit(arr, s, e);
        quickSortInternal(arr, s, p - 1);
        quickSortInternal(arr, p + 1, e);
    }

    public static int povit(int[] arr, int s, int e) {
        int p = arr[e];
        int k = s;
        for (int i = s; i < e; i++) {
            if (p > arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
                k++;
            }
        }
        int tmp = arr[k];
        arr[k] = p;
        arr[e] = tmp;
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 4, 9, 6, 5, 2};
        for (int i: arr) {
            System.out.println(i);
        }
        System.out.println();
        quickSort(arr);
        for (int i: arr) {
            System.out.println(i);
        }
    }
}
