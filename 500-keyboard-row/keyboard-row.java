class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>(); // List to store words typeable on one row
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"}; // Keyboard rows
        for (String word : words) { // Go through each word in the input
            String lower = word.toLowerCase(); // Convert word to lowercase for easy checking
            for (String row : rows) { // Go through each keyboard row
                if (isValid(row, lower)) { // Check if the word can be typed on this row
                    result.add(word); // Add original word to the result if it's vali
                }
            }
        }
        return result.toArray(new String[0]); // Convert list to a String array and return
    }
    private boolean isValid(String row, String word) {
        for (char c : word.toCharArray()) { // Go through each character in the word
            if (row.indexOf(c) < 0) return false; // Char not in row
        }
        return true; // All characters are in the row
    }
}