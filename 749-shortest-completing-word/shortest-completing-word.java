class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String str = licensePlate.replaceAll("[^A-Za-z]","").toLowerCase();
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        String shortest = null;
        for(String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for(char ch : word.toLowerCase().toCharArray()) 
            {
                wordMap.put(ch, wordMap.getOrDefault(ch,0)+1);
            }

            boolean valid = true;
            for(Map.Entry<Character,Integer> entry : map.entrySet()) 
            {
                char key = entry.getKey();
                int count = entry.getValue();

                if(wordMap.getOrDefault(key,0) < count) 
                {  
                    valid = false;
                    break;
                }
            }

            if(valid && (shortest == null || word.length() < shortest.length())) 
            {
                shortest = word;
            }
        }

        return shortest;
    }
}