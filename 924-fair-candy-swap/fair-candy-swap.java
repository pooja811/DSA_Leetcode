class Solution {
  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int aliceTotal = 0;
    int bobTotal = 0;
    for (int candies : aliceSizes) aliceTotal += candies;
    for (int candies : bobSizes) bobTotal += candies;
        
    Set<Integer> targets = new HashSet<>();
    for (int i = 0, m = aliceSizes.length; i < m; i++)
      targets.add((bobTotal - aliceTotal + 2 * aliceSizes[i]) / 2);

    for (int j = 0, n = bobSizes.length; j < n; j++)
      if (targets.contains(bobSizes[j]))
        return new int[] { (aliceTotal + 2 * bobSizes[j] - bobTotal) / 2, bobSizes[j] };

    return new int[0];
  }
}