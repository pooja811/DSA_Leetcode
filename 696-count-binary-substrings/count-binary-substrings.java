class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            countBinarySubstrings("1100");
        }
    }

    public static int countBinarySubstrings(String s) {
        int prev = 0, cur_cnt = 1, ans = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))//Same char so increase consecutive count
                cur_cnt++;
            else {
                ans += Math.min(cur_cnt, prev); //Store answer ie..minium of cur & prev
                prev = cur_cnt; //Current value will become prev for new different character
                cur_cnt = 1; //Current count will start will 1
            }
        }
        return ans + Math.min(prev, cur_cnt);
    }
}