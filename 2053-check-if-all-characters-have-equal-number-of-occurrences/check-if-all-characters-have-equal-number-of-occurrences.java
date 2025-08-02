class Solution {
    public boolean areOccurrencesEqual(String s) {
        int [] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        int x =0;
        for(int i : arr){
            if(i !=0 && x==0){
                x=i;
            }else if(i != 0){
                if(x != i){
                    return false;
                }
            }
        }
        return true;
    }
}