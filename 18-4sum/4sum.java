import java.util.AbstractList;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        if (arr.length < 4)
            return Collections.emptyList();
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ans;

            @Override
            public int size() {
                if (ans == null)
                    ans = createList(arr, target);
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if (ans == null)
                    ans = createList(arr, target);
                return ans.get(index);
            }
        };
    }

    private List<List<Integer>> createList(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1])
                            left++;
                        while (left < right && arr[right] == arr[right + 1])
                            right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }

            }
        }
        return ans;
    }
}