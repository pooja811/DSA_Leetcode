class Solution {
    public boolean detectCapitalUse(String w) {
        int len = w.length();
        if (len == 1) return true;
        int i = 0;
        boolean f = false;
        if (!isUp(w.charAt(0))) i = 1;
        else {
            i = 2;
            f = isUp(w.charAt(1));
        }
        for (; i < len; ++i) 
            if (f != isUp(w.charAt(i))) return false;
        return true;
    }
    private boolean isUp(char c) {
        return c - 'a' < 0 ? true : false;
    }
}