class Solution {
    public String reverseWords(String s) {
       StringBuilder ans = new StringBuilder();
       for(String str : s.split(" ")){
        ans.append(new StringBuilder(str).reverse()).append(" ");
       }
       return ans.toString().trim();
    }
}