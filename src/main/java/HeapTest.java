import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapTest {
    public static void main(String[] args) {
        Integer[] target = { 98, 0, 2, 3, 5, 8, 11, 22, 97, 98, 33, 44, 55, 66, 77, 88, 99, 100, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        Queue<Integer> queue = new PriorityQueue<Integer>(5, new Comparator<Integer>() { //大顶堆，容量11
            @Override
            public int compare(Integer i1,Integer i2){
                return i1 - i2;
            }
        });
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        for (Integer num : target) {
            Integer top = queue.peek();
            if (num > top) {
                queue.poll();
                queue.add(num);
            }
        }

        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

}