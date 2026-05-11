class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            String s = Integer.toString(num);
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i) - '0');
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}