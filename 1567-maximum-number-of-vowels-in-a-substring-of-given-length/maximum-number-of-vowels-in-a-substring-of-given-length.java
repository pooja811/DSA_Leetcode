class Solution {
    public int maxVowels(String s, int k) {
        int l=0, r=0, window=0, res=0;
        for(r=0;r<k; r++){
            window += isVowel(s.charAt(r));
        }
        res= window;
        while(r<s.length()){
            window -= isVowel(s.charAt(l++));
            window += isVowel(s.charAt(r++));
            res = Math.max(res, window);
        }
        return res;
    }
    public int isVowel(char c){
        return (c == 'a'|| c=='e' || c=='i' || c=='o' || c=='u')?1:0;
    }
}