class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).sorted()
				.mapToInt(Integer::intValue)
				.toArray();
		int n = arr.length;
		if (n % 2 == 1) {
			return arr[n / 2];
		} else {
			return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
		}

    }
}