

public class Package {

    public static int count = 0;
    public static int maxW = Integer.MIN_VALUE;

    // i 已扫描的物品，cw 已装物品总重量，items 物品列表，背包可用容量
    public static void f(int i, int cw, int[] items, int n, int w, int index) {
        if (index > 2 || cw > w || i == n) {
            return;
        }
        if (cw == w && index == 2) {
            count++;
            if (cw > maxW) maxW = cw;
            return; // 已满，或物品都装完
        }
        f(i + 1, cw, items, n, w, index);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        f(0, 0, arr, arr.length, 11, 0);
        System.out.println(count);
    }
}
