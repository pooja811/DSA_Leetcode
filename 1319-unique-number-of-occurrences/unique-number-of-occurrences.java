class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int [] ca = new int[2001];
        for(int i : arr){
            ca[i + 1000]++;
        }
        Arrays.sort(ca);
        for(int i=0;i<2000;i++){
            if(ca[i]!=0 && ca[i]==ca[i+1]){
                return false;
            }
        }
        return true;
    }
}