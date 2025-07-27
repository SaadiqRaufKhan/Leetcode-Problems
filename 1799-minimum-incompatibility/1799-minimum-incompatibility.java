class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        if(k == n) return 0;

        // Use a bitmask to denote which elements are included or not in the subsets
        // Note that we will mask the Indices and not the elements
        // since the max size of nums = 16, a 16-bit bitmask will do the job
        // ith set bit in the mask means that the subset has nums[i]
        
        // First step is to create all "valid" subsets
        // valid -> no duplicates, set bits = n/k

        int subsetSize = n / k;
        Map<Integer, Integer> validSubsets = new HashMap<>();
        for(int mask=1; mask<1<<n; mask++) {
            if(Integer.bitCount(mask) != subsetSize) continue; // invalid

            // passed bitcount, now check other conditions for this mask
            // also compute the incomp. score if it is valid
            int minval = Integer.MAX_VALUE;
            int maxval = Integer.MIN_VALUE;
            Set<Integer> seen = new HashSet<>();
            boolean valid = true;

            for(int i=0; i<n; i++) {
                if((mask & (1<<i)) != 0) {   // check if ith bit is set
                    if(seen.contains(nums[i])) {    // check if element is duplicate
                        valid = false;
                        break;
                    }
                    seen.add(nums[i]);
                    minval = Math.min(minval, nums[i]);
                    maxval = Math.max(maxval, nums[i]);
                }
            }

            if(valid) {
                validSubsets.put(mask, maxval - minval);
            }
        }

        // now we have all the valid masks ready
        // these masks represent the vaid distribution of the indices

        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int mask = 0; mask < (1 << n); mask++) {
            if(dp[mask] != Integer.MAX_VALUE) {
                for(int subset: validSubsets.keySet()) {
                    if((subset & mask) == 0) {  // no overlap i.e. disjoint subsets
                        int union = subset | mask;
                        dp[union] = Math.min(dp[union], dp[mask] + validSubsets.get(subset));
                    }

                }
            }
        }

        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }
}