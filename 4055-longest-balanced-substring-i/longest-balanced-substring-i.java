class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0 ;

        for(int i = 0 ; i<n ; i++){
            int [] freq = new int[26];
            for(int j = i ; j<n; j++){
                freq[s.charAt(j)-'a']++;

                int commonFreq = -1;
                boolean balanced =true;
                for(int c : freq){
                    if(c ==0){
                        continue;
                    }
                    if(commonFreq == -1){
                        commonFreq =c;
                    }else if(c != commonFreq){
                        balanced = false;
                        break;
                    } 
                }
                if(balanced){
                    maxLen= Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
}