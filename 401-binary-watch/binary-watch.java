class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res=new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                int t=Integer.bitCount(h)+Integer.bitCount(m);
                if(t==turnedOn){
                    if(m<10){
                        res.add(h+":0"+m);
                    }
                    else{
                        res.add(h+":"+m);
                    }
                }
            }
        }
        return res;
    }
}