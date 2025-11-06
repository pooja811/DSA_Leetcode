class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            List<String> temp = map.getOrDefault(sortedWord, new ArrayList<>());
            temp.add(strs[i]);
            map.put(sortedWord, temp);
        }
        return new ArrayList<>(map.values());
    }
}