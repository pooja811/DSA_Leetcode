class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
		int index = str.length - 1;
		return str[index].trim().length();
    }
}