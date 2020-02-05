

public class Package {


    public static int maxW = Integer.MIN_VALUE;

    // i 已扫描的物品，cw 已装物品总重量，items 物品列表，背包可用容量
    public static void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return; // 已满，或物品都装完
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        f(0, 0, a, 10, 100);
    }
}
