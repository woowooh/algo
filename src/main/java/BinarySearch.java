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

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int r = binarySearch(arr, 3);
        System.out.println(r);
    }
}
