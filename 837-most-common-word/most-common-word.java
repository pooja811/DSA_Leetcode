
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map <String, Integer> wordsMap = new HashMap();
        for (String bannedWord: banned) {
            wordsMap.put(bannedWord, -1);
        }
        var currentWord = new StringBuilder();
        String mostCommon = null;
        int mostCommonCount = -1;
        var chars = paragraph.toCharArray();

        for (int i=0; i < chars.length; i ++) {
            var curChar = Character.toLowerCase(chars[i]);
            if (Character.isLetter(curChar)) {
                currentWord.append(Character.toLowerCase(curChar));
                if (i + 1 < chars.length)
                    continue;
            }

            if(currentWord.length() == 0) {
                continue;
            }
            String word = currentWord.toString();
            currentWord = new StringBuilder();
            if (word.isEmpty()) {
                continue;
            }
            int count = wordsMap.getOrDefault(word, 0);
            if (count == -1) {
                continue;
            }
            count++;
            if (count > mostCommonCount) {
                mostCommonCount = count;
                mostCommon = word;
            } 
            wordsMap.put(word, count);
        }
        return mostCommon;
     }
}