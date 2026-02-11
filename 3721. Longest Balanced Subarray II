class LazyTag {
    int add;   // value to add to this segment

    LazyTag() {
        this.add = 0;
    }

    void merge(LazyTag other) {
        this.add += other.add;
    }

    boolean isEmpty() {
        return add == 0;
    }

    void clear() {
        add = 0;
    }
}


class SegmentTreeNode {
    int min;        // minimum prefix sum in this segment
    int max;        // maximum prefix sum in this segment
    LazyTag lazy;   // pending range addition

    SegmentTreeNode() {
        min = max = 0;
        lazy = new LazyTag();
    }
}


class SegmentTree {

    private final int n;
    private final SegmentTreeNode[] tree;

    SegmentTree(int[] prefix) {
        this.n = prefix.length;
        tree = new SegmentTreeNode[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegmentTreeNode();
        }
        build(prefix, 1, n, 1);
    }

 

    // Add value to range [l, r] (1-indexed)
    void add(int l, int r, int value) {
        if (l > r) return;
        LazyTag tag = new LazyTag();
        tag.add = value;
        rangeAdd(l, r, tag, 1, n, 1);
    }

    // Find rightmost index >= start with prefix sum == value
    int findLast(int start, int value) {
        if (start > n) return -1;
        return query(start, n, value, 1, n, 1);  // int ql = 0, int qr = 5 , int target = 0, int l = 1, int r = 5 , int idx = 1
    }

    /* ---------- Tree Construction ---------- */

    private void build(int[] data, int l, int r, int idx) {
        if (l == r) {
            tree[idx].min = tree[idx].max = data[l - 1];
            return;
        }

        int mid = (l + r) >> 1;
        build(data, l, mid, idx << 1);
        build(data, mid + 1, r, idx << 1 | 1);
        pullUp(idx);
    }

    /* ---------- Lazy Propagation ---------- */

    private void apply(int idx, LazyTag tag) {
        tree[idx].min += tag.add;
        tree[idx].max += tag.add;
        tree[idx].lazy.merge(tag);
    }

    private void pushDown(int idx) {
        if (!tree[idx].lazy.isEmpty()) {
            apply(idx << 1, tree[idx].lazy);
            apply(idx << 1 | 1, tree[idx].lazy);
            tree[idx].lazy.clear();
        }
    }

    private void pullUp(int idx) {
        tree[idx].min = Math.min(tree[idx << 1].min, tree[idx << 1 | 1].min);
        tree[idx].max = Math.max(tree[idx << 1].max, tree[idx << 1 | 1].max);
    }

    /* ---------- Range Update ---------- */

    private void rangeAdd(
        int ql, int qr, LazyTag tag,
        int l, int r, int idx
    ) {
        if (ql <= l && r <= qr) {
            apply(idx, tag);
            return;
        }

        pushDown(idx);
        int mid = (l + r) >> 1;

        if (ql <= mid) rangeAdd(ql, qr, tag, l, mid, idx << 1);
        if (qr > mid)  rangeAdd(ql, qr, tag, mid + 1, r, idx << 1 | 1);

        pullUp(idx);
    }

    /* ---------- Query Rightmost Value ---------- */

    private int query(    // int ql = 0, int qr = 5 , int target = 0, int l = 1, int r = 5 , int idx = 1
        int ql, int qr, int target,
        int l, int r, int idx
    ) {
        if (tree[idx].min > target || tree[idx].max < target) {
            return -1;
        }

        if (l == r) return l;

        pushDown(idx);
        int mid = (l + r) >> 1;

        // search right side first
        if (qr > mid) {
            int res = query(ql, qr, target, mid + 1, r, idx << 1 | 1); //// int ql = 0, int qr = 5 , int target = 0, int l = 4, int r = 5 , int idx = 3
            if (res != -1) return res;
        }

        if (ql <= mid) {
            return query(ql, qr, target, l, mid, idx << 1);
        }

        return -1;
    }
}



class Solution {

    public int longestBalanced(int[] nums) {
        int n = nums.length;

        // store all occurrence positions (1-indexed)
        Map<Integer, Queue<Integer>> positions = new HashMap<>();

        int[] prefix = new int[n];
        prefix[0] = parity(nums[0]);
        positions.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        // build prefix sums with distinct contribution
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            Queue<Integer> q = positions.computeIfAbsent(nums[i], k -> new LinkedList<>());
            if (q.isEmpty()) {
                prefix[i] += parity(nums[i]);
            }
            q.add(i + 1);
        }

        SegmentTree segTree = new SegmentTree(prefix);
        int best = 0;

        // slide left boundary
        for (int left = 0; left < n; left++) {

            int right = segTree.findLast(left + best, 0);
            if (right != -1) {
                best = Math.max(best, right - left);
            }

            // remove contribution of nums[left]
            Queue<Integer> q = positions.get(nums[left]);
            q.poll();

            int nextPos = q.isEmpty() ? n + 1 : q.peek();
            segTree.add(left + 1, nextPos - 1, -parity(nums[left]));
        }

        return best;
    }

    // even → +1, odd → -1
    private int parity(int x) {
        return (x & 1) == 0 ? 1 : -1;
    }
}
