class Solution {
    public boolean isAnagram(String s, String t) {
        String collect = s.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
        String collect1 = t.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
        if (s.length() != t.length()) {
            return false;
        }
        if (!collect.equals(collect1)) {
            return false;
        }
        return true;
    }
}