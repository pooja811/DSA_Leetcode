class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         if(nums1.length == 0 || nums2.length ==0 ) return new int[0];
        int f[]=new int[1001];
        int r[]=new int[nums1.length];
        int z=0;
        for(int i:nums1)f[i]++;
        for(int i:nums2){
            if(f[i]>0){
                r[z++]=i;
                f[i]=0;
            }
        }
        return Arrays.copyOfRange(r,0,z);
    }
}