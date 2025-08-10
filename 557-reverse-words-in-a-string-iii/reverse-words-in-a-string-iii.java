class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
		String ans = "";
		for (String i : strArr) {
			StringBuilder sb = new StringBuilder(i);
			sb.reverse();
			ans = ans + sb + " ";
		}
		return ans.trim();
    }
}