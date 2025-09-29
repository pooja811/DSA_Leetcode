class Solution {
     public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            char peek = sb.length() > 0 ? sb.charAt(sb.length()-1) : '1';
            if(Math.abs(peek - c) == 32 && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}