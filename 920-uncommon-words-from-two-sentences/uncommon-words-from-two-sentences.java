class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
         Map<String, Integer> freq = new HashMap<>();

        // Count words in both sentences
        for (String word : s1.split(" ")) freq.put(word, freq.getOrDefault(word, 0) + 1);
        for (String word : s2.split(" ")) freq.put(word, freq.getOrDefault(word, 0) + 1);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) result.add(entry.getKey());
        }

        return result.toArray(new String[0]);
    }
}