class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> charSet = new HashSet<>();
        for(int i=0; i<sentence.length();i++){
            char c = sentence.charAt(i);
            charSet.add(c);
        }
        return charSet.size()==26;
    }
}