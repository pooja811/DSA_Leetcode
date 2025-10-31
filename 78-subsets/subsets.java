class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int nums[],int start, List<Integer> current, List<List<Integer>> result){
        // add the current subset to the result
        result.add(new ArrayList<>(current));
        // explore all posibilities
        for(int i = start; i<nums.length;i++){
            current.add(nums[i]);
            backtrack(nums,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
}