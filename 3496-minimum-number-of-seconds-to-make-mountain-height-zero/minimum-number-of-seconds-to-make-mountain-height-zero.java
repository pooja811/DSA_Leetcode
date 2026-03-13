import java.util.Arrays;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        
        long lowTime = 0;
        long highTime = (long) 1e16; 
        long minRequiredTime = highTime;
        
        // Outer Binary Search: Finding the minimum required time
        while (lowTime <= highTime) {
            long midTime = lowTime + (highTime - lowTime) / 2;
            long totalHeightReduced = 0;
            
            for (int baseTime : workerTimes) {
                // Inner Binary Search: Finding max height THIS worker can reduce in 'midTime'
                long lowHeight = 0;
                long highHeight = mountainHeight;
                long maxWorkerHeight = 0;
                
                while (lowHeight <= highHeight) {
                    long midHeight = lowHeight + (highHeight - lowHeight) / 2;
                    
                    // Crucial: Cast to long BEFORE multiplying to prevent 32-bit overflow
                    long timeNeeded = (long) baseTime * midHeight * (midHeight + 1) / 2;
                    
                    if (timeNeeded <= midTime) {
                        maxWorkerHeight = midHeight;
                        lowHeight = midHeight + 1;
                    } else {
                        highHeight = midHeight - 1;
                    }
                }
                
                totalHeightReduced += maxWorkerHeight;
                
                // Early Exit Optimization
                if (totalHeightReduced >= mountainHeight) {
                    break;
                }
            }
            
            // Adjust outer binary search bounds
            if (totalHeightReduced >= mountainHeight) {
                minRequiredTime = midTime;
                highTime = midTime - 1;
            } else {
                lowTime = midTime + 1;
            }
        }
        
        return minRequiredTime;
    }
}