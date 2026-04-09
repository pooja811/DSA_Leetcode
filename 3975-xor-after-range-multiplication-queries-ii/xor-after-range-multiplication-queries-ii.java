class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        // MOD is the modulus for all multiplications (10^9+7, a prime number)
        int MOD = (int)1e9+7, n = nums.length, m = queries.length;
        // B = sqrt(n) – the threshold that separates "large k" from "small k"
        int B = (int)Math.sqrt(n);
        
        // store[k][rem] will hold all queries with step k (< B) and remainder rem = l % k
        // We need size B+1 because k can be up to B-1 (and we use index k directly)
        ArrayList<int[]>[][] store = new ArrayList[B+1][B+1];

        // Initialise every cell with an empty ArrayList
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                store[i][j] = new ArrayList<>();
            }
        }

        // ----- Process all queries -----
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            int k = queries[i][2], v = queries[i][3];

            if (k >= B) {
                // Large step: update the array directly
                // We touch at most n/k ≤ n/B = √n indices – fast enough
                for (int idx = l; idx <= r; idx += k) {
                    nums[idx] = (int)((1L * nums[idx] * v) % MOD);
                }
            } else {
                // Small step: store the query for later processing
                int remainder = l % k;          // all affected indices have this remainder modulo k
                store[k][remainder].add(new int[]{l, r, v}); // keep l, r, v for this group
            }
        }

        // ----- Process all stored small‑step queries -----
        for (int k = 1; k < B; k++) {               // step size from 1 to B-1
            for (int rem = 0; rem < k; rem++) {     // each possible remainder modulo k
                if (store[k][rem].isEmpty()) continue;

                ArrayList<int[]> queriesList = store[k][rem];

                // Number of indices in this residue chain: indices rem, rem+k, rem+2k, ... < n
                int chainLength = (n - rem + k - 1) / k;   // ceiling division

                // diff array for range multiplications on this chain
                // We use multiplication difference: to multiply [start, end] by v,
                // we do diff[start] *= v and diff[end+1] *= inv(v)
                long[] diff = new long[chainLength + 1];
                Arrays.fill(diff, 1L);              // multiplicative identity is 1

                for (int[] q : queriesList) {
                    int l = q[0], r = q[1], v = q[2];

                    // Convert original indices to positions in the chain
                    int startPos = (l - rem) / k;
                    int endPos   = (r - rem) / k;
                    
                    // Clamp to valid range
                    if (startPos < 0) startPos = 0;
                    if (endPos >= chainLength) endPos = chainLength - 1;
                    if (startPos > endPos) continue;

                    // Apply range multiplication using the difference array trick
                    diff[startPos] = (diff[startPos] * v) % MOD;
                    if (endPos + 1 < chainLength) {
                        diff[endPos + 1] = (diff[endPos + 1] * modInverse(v, MOD)) % MOD;
                    }
                }

                // Now sweep through the chain, maintaining the cumulative product
                long curr = 1L;
                for (int pos = 0; pos < chainLength; pos++) {
                    curr = (curr * diff[pos]) % MOD;           // apply all active multiplications
                    int idx = rem + pos * k;                   // original index in nums
                    nums[idx] = (int)((1L * nums[idx] * curr) % MOD);
                }
            }
        }

        // ----- Final XOR of all elements -----
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }

    // Modular inverse using Fermat's little theorem (MOD is prime)
    private long modInverse(long a, int MOD) {
        return pow(a, MOD - 2, MOD);
    }

    // Fast exponentiation (binary exponentiation)
    private long pow(long a, long b, int MOD) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}