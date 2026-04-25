class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long perimeter = 4L * side;
        int n = points.length;

        // Convert each point to its position on the unrolled perimeter
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            long x = points[i][0], y = points[i][1];
            if (y == 0)        pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 3L * side - x;
            else                pos[i] = 4L * side - y;
        }
        Arrays.sort(pos);

        // Double the array to handle circular wrap-around
        long[] doubled = new long[2 * n];
        for (int i = 0; i < n; i++) {
            doubled[i] = pos[i];
            doubled[i + n] = pos[i] + perimeter;
        }

        long lo = 1, hi = 2L * side, ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (canPlace(doubled, k, mid, perimeter, n)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean canPlace(long[] doubled, int k, long d, long perimeter, int n) {
        for (int start = 0; start < n; start++) {
            int count = 1;
            long cur = doubled[start];
            long limit = doubled[start] + perimeter - d;
            int idx = start;
            while (true) {
                // Binary search for next point >= cur + d
                int lo = idx + 1, hi = 2 * n - 1, next = 2 * n;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (doubled[mid] >= cur + d) { next = mid; hi = mid - 1; }
                    else lo = mid + 1;
                }
                if (next >= 2 * n || doubled[next] > limit) break;
                cur = doubled[next];
                idx = next;
                if (++count == k) return true;
            }
        }
        return false;
    }
}