import java.util.*;

class Solution {

    private int longestTwoCharSegment(String s,int start,int end){
        start = Math.max(0,start);

        Map<Integer,Integer> parityMap=new HashMap<>();
        parityMap.put(0,start-1);

        int balance=0,best=0,lastChar=-1,sign=-1;

        for(int i=start;i<end;i++){
            int v=s.charAt(i)-'a';

            if(v!=lastChar){
                lastChar=v;
                sign*=-1;
            }

            balance+=sign;

            if(parityMap.containsKey(balance))
                best=Math.max(best,i-parityMap.get(balance));
            else
                parityMap.put(balance,i);
        }

        return best;
    }

    public int longestBalanced(String s) {
        Map<String,Integer> diffMap=new HashMap<>();
        diffMap.put("0,0,0",-1);

        int[] counts=new int[3];

        int lastCharVal=-1,lastCharIdx=-1;
        int pair0=-1,pair1=-1;
        int twoCharStart=0;

        int best=0;

        for(int i=0;i<s.length();i++){
            int v=s.charAt(i)-'a';
            counts[v]++;

            int m=Math.min(counts[0],
                    Math.min(counts[1],counts[2]));
            if(m>0)
                for(int j=0;j<3;j++) counts[j]-=m;

            String key=counts[0]+","+counts[1]+","+counts[2];

            if(diffMap.containsKey(key))
                best=Math.max(best,i-diffMap.get(key));
            else
                diffMap.put(key,i);

            if(v!=lastCharVal){
                best=Math.max(best,i-lastCharIdx);

                if(v!=pair0 && v!=pair1){
                    pair0=lastCharVal;
                    pair1=v;

                    best=Math.max(best,
                        longestTwoCharSegment(s,twoCharStart,i));

                    twoCharStart=Math.max(0,lastCharIdx);
                }

                lastCharVal=v;
                lastCharIdx=i;
            }
        }

        best=Math.max(best,
            longestTwoCharSegment(s,
                Math.max(0,twoCharStart),
                s.length()));

        best=Math.max(best,s.length()-lastCharIdx);

        return best;
    }
}
