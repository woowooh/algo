

public class MergeArray {
    public static int[] r;

    public static void main(String[] args) {
        int[] arrA = {1, 3, 5, 7, 9};
        int[] arrB = {2, 4, 6, 8, 10};
        int[] result = merge(arrA, arrB);
        for (int i: result) {
            System.out.print(i + ", ");
        }
        int[] arrc = {0, 8, 6, 2, 4, 6, 8, 10};
        System.out.println("new");
        mergeSort(arrc);
        System.out.println();
        for (int i: arrc) {
            System.out.print(i + ", ");
        }

    }

    public static int[] merge(int[] arrA, int[] arrB) {
        int[] result = new int[arrA.length + arrB.length];
        int i = 0, j = 0, k = 0;
        while ((i < arrA.length) && (j < arrB.length)) {
            if (arrA[i] > arrB[j]) {
                result[k] = arrB[j];
                j++;
            } else {
                result[k] = arrA[i];
                i++;
            }
            k++;
        }
        if (i == arrA.length) {
            for (; j < arrB.length; j++) {
                result[k] = arrB[j];
                k++;
            }
        } else {
            for (; i < arrB.length; i++) {
                result[k] = arrB[i];
                k++;
            }
        }
        return result;
    }

    public static void mergeSort(int[] arr) {
        r = new int[arr.length];
        doMergeSort(arr, 0, arr.length - 1);
    }

    public static void doMergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        doMergeSort(arr, left, mid);
        doMergeSort(arr, mid + 1, right);
        mergeTwo(arr, left, mid, right);
    }

    public static void mergeTwo(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                r[k] = arr[j];
                j++;
            } else {
                r[k] = arr[i];
                i++;
            }
            k++;
        }
        if (i > mid) {
            for (; j <= right; j++) {
                r[k] = arr[j];
                k++;
            }
        } else {
            for (; i <= mid; i++) {
                r[k] = arr[i];
                k++;
            }
        }
        for (i = 0; i < k; i++) {
            arr[left + i] = r[i];
        }
    }
}