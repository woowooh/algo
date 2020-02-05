

public class MergeSort {
    public static int[] brr;
    public static int sum = 0;
    public static void mergeSort(int[] arr) {
        brr = new int[arr.length];
        mergeSortInternal(arr, 0, arr.length - 1);
    }

    public static void mergeCountSeq(int[] arr) {
        brr = new int[arr.length];
        mergeCountInternal(arr, 0, arr.length - 1);
    }


    public static void mergeSortInternal(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + ((e - s) / 2);
        mergeSortInternal(arr, s, mid);
        mergeSortInternal(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    public static void merge(int[] arr, int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = s;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                brr[k] = arr[i];
                i++;
            } else {
                brr[k] = arr[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= e) {
                brr[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                brr[k] = arr[i];
                i++;
                k++;
            }
        }
        for (i = s; i <= e; i++) {
            arr[i] = brr[i];
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int p = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] < p) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = p;
        }
    }

    public static void mergeCountInternal(int[] arr, int s, int e) {
        sum = 0;
        if (s >= e) {
            return;
        }
        int mid = s + ((e - s) / 2);
        mergeCountInternal(arr, s, mid);
        mergeCountInternal(arr, mid + 1, e);
        mergeCount(arr, s, mid, e);
    }

    public static void mergeCount(int[] arr, int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = s;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                brr[k] = arr[i];
                i++;
            } else {
                sum += (mid - i + 1);
                brr[k] = arr[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= e) {
                brr[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                brr[k] = arr[i];
                i++;
                k++;
            }
        }
        for (i = s; i <= e; i++) {
            arr[i] = brr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 4, 9, 6, 5, 2};
        int[] nrr = {0, 3, 1, 4, 9, 6, 5, 2};
        mergeSort(arr);
        for (int i: arr) {
            System.out.print(i);
        }
        System.out.println();
//        insertSort(nrr);
//        System.out.println();
//        for (int i: arr) {
//            System.out.print(i);
//        }
        mergeCountSeq(nrr);
        System.out.println(sum);
    }
}
