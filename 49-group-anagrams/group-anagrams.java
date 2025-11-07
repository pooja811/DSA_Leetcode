class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagrams = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str : strs){
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String sortedStr = new String(chArray);
            if(!anagrams.containsKey(sortedStr)){
                 List<String> list = new ArrayList<>();
                 list.add(str);
                 anagrams.put(sortedStr,list);
            }else{
               anagrams.get(sortedStr).add(str);
            }
        }
        
        for(List<String> list : anagrams.values()){
            ans.add(list);
        }
        return ans;
    }
}
/**
Time : n*O(m(logm))
n is number of strings in array
m is length of each string

Space : O(n*m)

 */