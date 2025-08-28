class Solution {
    Map<Character, char[]> map;

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return output;
        }
        map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        bt(0, digits.toCharArray(), new StringBuilder(), output);
        return output;
    }

    void bt(int i, char[] input, StringBuilder pref, List<String> output) {
        if (i == input.length) {
            output.add(pref.toString());
            return;
        }
        for (char c : map.get(input[i])) {
            pref.append(c);
            bt(i + 1, input, pref, output);
            pref.setLength(pref.length() - 1);
        }
    }
}