class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, i = 0;
        List<String> parts = new ArrayList<>();  
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                parts.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        Collections.sort(parts, Collections.reverseOrder());    
        return String.join("", parts);
    }
}