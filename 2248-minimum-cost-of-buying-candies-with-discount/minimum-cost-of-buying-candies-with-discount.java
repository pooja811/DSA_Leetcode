import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        Integer[] arr = Arrays.stream(cost).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 3 != 2) {
                total += arr[i];
            }
        }

        return total;
    }
}