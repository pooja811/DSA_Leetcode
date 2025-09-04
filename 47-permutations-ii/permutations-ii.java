class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        helper(nums, res, map, temp);
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, Map<Integer, Integer> map, List<Integer> temp) {
        if(temp.size()==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int num:map.keySet())
        {
            if(map.get(num)>0)
            {
                temp.add(num);
                map.put(num, map.get(num)-1);
                helper(nums, res, map, temp);
                temp.remove(temp.size()-1);
                map.put(num, map.get(num)+1);
            }
        }
    }
}