

public class EightQueen {
    static int[] result = new int[8]; // 下标 0, 1, 2, 3 代表行，value 为列
    static int count = 0;

    public static void solution(int row) {
        if (row == 8) {
            print(result);
            count++;
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                solution(row + 1);
            }
        }
    }

    public static void print(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public static void main(String[] args) {
        solution(0);
        System.out.println(count);
    }
}
