class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int count = 1;
        int sum = 0;
        for(char c : s.toCharArray()){
            int w = widths[c - 'a'];
            sum += w;
            if(sum > 100){
                count++;
                sum = w;
            }
        }
        return new int [] {count,sum};
    }
}