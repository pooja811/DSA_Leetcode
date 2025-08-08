class Solution {
    public boolean uniqueOccurrences(int[] arr) {
          // Step 1: Count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store counts in a set to check uniqueness
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());

        // Step 3: Compare sizes
        return countMap.size() == occurrenceSet.size();
    }
}