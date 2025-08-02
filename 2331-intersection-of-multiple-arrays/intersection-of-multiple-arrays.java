class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int [] ar : nums){
            for(int i : ar){
                map.put(i ,map.getOrDefault(i, 0)+1);
            }
        }
         return map.keySet().stream().filter(i->map.get(i)==n).sorted().toList();
    }
}