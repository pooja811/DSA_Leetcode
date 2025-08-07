class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x=0, y =0;
        set.add(0+","+0);
        for(char c : path.toCharArray()){
            if(c=='N'){
                y++;
            }else if(c=='W'){
                x--;
            }else if(c=='S'){
                y--;
            }else if(c=='E'){
                x++;
            }
            String coordinates = x + "," + y;
            if(set.contains(coordinates)){
                return true;
            }
            set.add(coordinates);
        }
        return false;
    }
}