import com.alibaba.fastjson.JSONObject;

public class Test {
    public static volatile int n = 0;

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 8, 5, 4, 0, 0};
        mSort(arr);
        for (int i: arr) {
            System.out.print(i + ",");
        }

        A a = new A();
        B b = new B();
        a.run();
        b.run();

    }

    static class A extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (n % 2 == 0) {
                    n++;
                    try{
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    static class B extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (n % 2 == 1) {
                    n++;
                    try{
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
            System.out.println(String.format("b n is {}", n));
        }
    }

//    public static void bsort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int tmp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }
//    }

//    public static void isort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int val = arr[i];
//            int j = i - 1;
//            for (;j >= 0; j--) {
//                if (arr[j] > val) {
//                    arr[j + 1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j + 1] = val;
//        }
//    }

    public static void bsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void isort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
    }

    public static void mSort(int[] arr) {
        mSortC(arr, 0, arr.length - 1);
    }

    public static void mSortC(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int m = s + (e - s)/ 2;
        mSortC(arr, s, m);
        mSortC(arr, m + 1, e);
        mm(arr, s, m, e);
    }

    public static void mm(int[] arr, int s, int m, int e) {
        int i = s, j = m + 1, k = 0;
        int[] brr = new int[e - s + 1];
        while (i <= m && j <= e) {
            if (arr[i] > arr[j]) {
                brr[k] = arr[j];
                j++;
            } else {
                brr[k] = arr[i];
                i++;
            }
            k++;
        }
        int start = i;
        int end = m;
        if (j <= e) {
            start = j;
            end = e;
        }
        while (start <= end) {
            brr[k++] = arr[start++];
        }
        for (i = 0; i <= e - s; i++) {
            arr[s + i] = brr[i];
        }
    }
}
