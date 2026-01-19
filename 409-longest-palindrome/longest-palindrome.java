public class Solution {
    // public int longestPalindrome(String s) {
    //     // Initialize a set to keep track of characters with odd frequencies
    //     HashSet<Character> charSet = new HashSet<>();
    //     int length = 0;
    //     for (char c : s.toCharArray()) {
    //         if (charSet.contains(c)) {
    //             charSet.remove(c);
    //             length += 2;
    //         } else {
    //             charSet.add(c);
    //         }
    //     }
        
    //     // If there are any characters left in the set, add 1 to the length for the middle character
    //     if (!charSet.isEmpty()) {
    //         length += 1;
    //     }
        
    //     // Return the total length of the longest palindrome
    //     return length;
    // }

    public int longestPalindrome(String s) {
        HashMap<Character,Integer> count=new HashMap<>();
        for(int i=0;i<s.length();i++)
        count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0)+1);
        int len=0;
        for(int i:count.values())
        len+=i/2*2;
        
        return (len<s.length())?len+1:len;
    }
}