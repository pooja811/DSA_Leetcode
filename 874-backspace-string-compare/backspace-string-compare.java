class Solution {
    public boolean backspaceCompare(String s, String t) {
        int r1 = s.length() - 1;
        int r2 = t.length() - 1;

        int count1 = 0;
        int count2 = 0;

        while(r1 >= 0 || r2 >= 0){
            while(r1 >= 0){
                if(s.charAt(r1) == '#'){
                    count1++;
                    r1--;
                }
                else if(count1 > 0){
                    count1--;
                    r1--;
                } else {
                    break;
                }
            }

            while(r2 >= 0){
                if(t.charAt(r2) == '#'){
                    count2++;
                    r2--;
                }
                else if(count2 > 0){
                    count2--;
                    r2--;
                } else {
                    break;
                }
            }
            if(r1 >= 0 && r2 >= 0){
                if(s.charAt(r1) != t.charAt(r2)){
                    return false;
                }
            } else {
                if(r1 >= 0 || r2 >= 0){
                    return false;
                }
            }

            r1--;
            r2--;
        }
        return true;
    }
}