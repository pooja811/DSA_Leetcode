class Solution {
    public boolean uniqueOccurrences(int[] arr) {
          // Step 1: Count occurrences of each number
         return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .collect(Collectors.toSet())
                .size() ==
               Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .size();
    }
}