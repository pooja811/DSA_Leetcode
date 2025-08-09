class Solution {
    public void reverseString(char[] s) {
        int l =0;
        int r = s.length;
        for(;l<s.length/2;l++){
            char temp = s[l];
            s[l]=s[r-1];
            s[r-1]=temp;
            r--;
        }
    }
}