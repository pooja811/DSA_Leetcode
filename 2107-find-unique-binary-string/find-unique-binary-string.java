// Added using AI
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set st = new HashSet<>();
        
        for(String s : nums) {
            st.add(Integer.parseInt(s, 2));
        }
        
        for(int i = 0; i < (1 << n); i++) {
            if(!st.contains(i)) {
                String binary = Integer.toBinaryString(i);
                while(binary.length() < n) {
                    binary = "0" + binary;
                }
                return binary;
            }
        }
        
        return "";
    }
}