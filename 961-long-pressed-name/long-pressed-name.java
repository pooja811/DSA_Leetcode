class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0,p2 = 0;
        int n = name.length(),m = typed.length();
        while(p2<m){
            if(p1<n && name.charAt(p1) == typed.charAt(p2)){
                p2++;
                p1++;
                continue ;
            }
            else if(p2>0 && typed.charAt(p2)==typed.charAt(p2-1)){
                p2++;
                continue ;
            }else{
                return false;
            }
        }
        return p1 == n;
    }
}