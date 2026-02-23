class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalcode=1<<k;
        if(s.length()<totalcode+k-1){
            return false;
        }
        Set<String> seen=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String code=s.substring(i,i+k);
            seen.add(code);
            if(seen.size()==totalcode){
                return true;
            }
        }
        return false;
    }
}