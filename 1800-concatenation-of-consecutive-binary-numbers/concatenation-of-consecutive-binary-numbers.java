class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int)1e9 + 7;
        long res = 0;
        for(int i=1; i<=n; i++) {
            int digits = 32 - Integer.numberOfLeadingZeros(i);
            res = ((((res << digits)%mod)+i)%mod);
        }
        return (int)res;
    }
}