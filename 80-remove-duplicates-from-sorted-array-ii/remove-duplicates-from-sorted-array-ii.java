class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int i = 1;

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i-1]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}