class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length-k+1];
        int p=0;
        Deque<Integer> dq = new ArrayDeque<>(); // this will store indexes
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1){ // for first window only
                ans[p++]=nums[dq.peekFirst()];
            }
        }

        return ans; 
    }
}