class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
    
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {  
                int direct = Math.abs(startIndex - i);
                int wrapAround = n - direct;
                int res = Math.min(direct, wrapAround);
                minDist = Math.min(minDist, res);
           }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}