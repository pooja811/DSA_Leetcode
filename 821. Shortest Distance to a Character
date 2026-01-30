class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        // fill first char ...
        int idx=findOccurence(c,n,0,s);
        for(int i=0;i<=idx;i++) answer[i]=idx-i;
        while(idx < n){
            int j = findOccurence(c,n,idx+1,s);
            if(j==n) break;
            for(int k=idx+1;k<j;k++) answer[k] = Math.min(
                Math.abs(k-idx),Math.abs(k-j)
            );
            idx=j;

        }
        for(int i=idx+1;i<n;i++) answer[i] = i-idx;
        return answer;
    }
    private int findOccurence(char c,int n,int i,String s){
        for(;i<n;i++) {
            if(s.charAt(i)==c) return i;
        }
        return i;
    }
}
