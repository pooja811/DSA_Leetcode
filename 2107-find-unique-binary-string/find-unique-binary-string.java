class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            char c=nums[i].charAt(i);
            String s=(c=='1'?"0":"1");
             sb.append(s);
        }
        return sb.toString();
    }
}