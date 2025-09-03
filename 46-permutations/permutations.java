class Solution {
    List<List<Integer>> permutations=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return permutations;
    }

    public void backtrack(int[] nums,int idx){
        if(idx==nums.length){
            List<Integer> permutation=new ArrayList<>();
            for(int num:nums) permutation.add(num);
            permutations.add(permutation);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            backtrack(nums,idx+1);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}