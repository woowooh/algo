public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int r = doSearch(arr, 0, arr.length - 1, target);
        return r;
    }

    public static int doSearch(int[] arr, int s, int e, int target) {
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (s >= e) return -1;
        if (arr[mid] > target) {
            return doSearch(arr, s, mid, target);
        } else {
            return doSearch(arr, mid + 1, e, target);
        }
    }

    public static int binarySearchLoop(int[] arr, int s, int e, int n) {
        int mid;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] > n) {
               e = mid - 1;
            } else if (arr[mid] < n) {
               s = mid + 1;
            } else {
               return mid;
            }
        }
        mid = -1;
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int r = binarySearchLoop(arr, 0, arr.length - 1, 2);
        System.out.println(r);
    }
}
