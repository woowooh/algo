

public class Knapsack {


    private static int maxW = Integer.MIN_VALUE;
    private static int[] weight = new int[]{1, 2, 4, 6, 3};
    private static int n = 5;
    private static int w = 10;
    private static boolean[][] mem = new boolean[5][10];
    private static int[] dp = new int[w + 1];

    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) { // 下次选择，因为是不选，所以 w 不需要减啥
                if (states[i - 1][j] == true) { // 需要依据上次的状态， 推理下次结果。
                    states[i][j] = states[i - 1][j];// states[n][w], w为装下的容量
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {

        int i = knapsack(weight, weight.length, 10);
        System.out.println(i);
    }
}
