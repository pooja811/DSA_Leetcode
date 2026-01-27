class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> str=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int a=map.get(list2[i])+i;
                map.put(list2[i],a);
                ans=Math.min(ans,a);
            }
        }
        for(String a:list2){
            if(map.get(a)!=null&&map.get(a)==ans)str.add(a);
        }
        return str.toArray(new String[0]);
    }
}