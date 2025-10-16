class Solution {
    public int thirdMax(int[] nums) {
        Long fe = Long.MIN_VALUE, se = Long.MIN_VALUE, te = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == fe || num == se || num == te) continue;
            if (num > fe) {
                te = se;
                se = fe;
                fe = (long) num;
            } else if (num > se) {
                te = se;
                se = (long) num;
            } else if (num > te) {
                te = (long) num;
            }
        }
        return (te == Long.MIN_VALUE) ? fe.intValue() : te.intValue();
    }
}