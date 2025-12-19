class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean inSegment = false;
        for (char c : s.toCharArray()) {
            if (c != ' ' && !inSegment) {
                count++;
                inSegment = true;
            } else if (c == ' ') {
                inSegment = false;
            }
        }
        return count;
    }
}
