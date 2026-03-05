class Solution {
    public int help(String s, char ch) {
        int ans = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0 && s.charAt(i) != ch) ans++;
            else if(i % 2 == 1 && s.charAt(i) == ch) ans++;
        }
        return ans;
    }
    public int minOperations(String s) {
        int opt1 = help(s, '0');
        int opt2 = help(s, '1');
        
        return Math.min(opt1, opt2);
    }
}