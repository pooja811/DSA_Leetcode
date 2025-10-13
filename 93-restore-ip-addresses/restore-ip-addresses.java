class Solution {
    List<String> ans = new ArrayList<>();
    void backtrack(String s, String path, int index, int count) {
        if (count > 4) return;
        if (count == 4 && index >= s.length()) {
            ans.add(path.substring(0,path.length()-1));
            return;
        }
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String num = s.substring(index, index + i);
            if (num.charAt(0) == '0' && i != 1) break;
            else if (Integer.parseInt(num) <= 255) {
                backtrack(s, path + s.substring(index, index + i) + ".", index + i,count + 1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, "", 0, 0);
        return ans;
    } 
}