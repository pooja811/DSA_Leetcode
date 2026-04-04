class Solution {
    public String decodeCiphertext(String s, int rows) {
        if (s.isEmpty()) return s;

        int n = s.length();
        int cols = (n + rows - 1) / rows;

        StringBuilder res = new StringBuilder();

        for (int start = 0; start < cols; start++) {
            int r = 0, c = start;
            while (r < rows && c < cols) {
                res.append(s.charAt(r * cols + c));
                r++; c++;
            }
        }

        int i = res.length();
        while (i > 0 && res.charAt(i - 1) == ' ') i--;
        return res.substring(0, i);
    }
}