

public class FindKthBig {
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 4, 9, 6, 5, 2};
        int r = findKthBig(arr, 2);
        System.out.println(r);
    }

    public static int findKthBig(int[] arr, int n) {
        int r, q;
        r = 0;
        q = arr.length - 1;
        int p = pivot(arr, r, q);
        while (p + 1 != n) {
            if (p >= n) {
                q = p - 1;
            } else {
                r = p + 1;
            }
            p = pivot(arr, r, q);
        }
        return arr[p];
    }

    public static int pivot(int[] arr, int s, int e) {
        int k = s;
        int p = arr[e];
        for (int j = s; j < e; j++) {
            if (arr[j] > p) {
                int tmp = arr[j];
                arr[j] = arr[k];
                arr[k] = tmp;
                k++;
            }
        }
        int tmp = arr[k];
        arr[k] = p;
        arr[e] = tmp;
        return k;
    }
}
