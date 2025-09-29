class Solution {
     public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!sb.isEmpty() && Math.abs(sb.charAt(sb.length() -1) - c) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}