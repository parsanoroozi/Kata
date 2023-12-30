package the_lift;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        final int[][] queues = {
                new int[0], // G
                new int[]{3}, // 1
                new int[]{4}, // 2
                new int[0], // 3
                new int[]{5}, // 4
                new int[0], // 5
                new int[0], // 6
        };
        final int[] result = Dinglemouse.theLift(queues,5);
        Arrays.stream(result).sequential().forEach(System.out::print);
    }
}
