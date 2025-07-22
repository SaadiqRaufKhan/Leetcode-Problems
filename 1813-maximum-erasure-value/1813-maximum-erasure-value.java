class Solution {
    
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];

        int maxScore = 0;
        for (int l=0, r=0; r<nums.length; r++) {
            prefixSum[r+1] = prefixSum[r] + nums[r];
            if (lastIndex.containsKey(nums[r])) 
                l = Math.max(l, lastIndex.get(nums[r]) + 1);
            maxScore = Math.max(maxScore, prefixSum[r+1] - prefixSum[l]);
            lastIndex.put(nums[r], r);
        }

        return maxScore;
    }
}

// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();

//         int l = 0;
//         int max_sum = 0;
//         int curr_sum = 0;
//         for(int r=0; r<nums.length; r++) {
//             int freq = map.getOrDefault(nums[r], 0);
//             map.put(nums[r], freq + 1);
//             if(freq == 0) { // new element
//                 curr_sum += nums[r];
//             }
//             else {  // duplicate element
//                 while(map.get(nums[l]) != 2) {
//                     curr_sum -= nums[l];
//                     map.put(nums[l], map.get(nums[l]) - 1);
//                     l++;
//                 }
//                 map.put(nums[l], 1);
//                 l++;
//             }
//             max_sum = Math.max(curr_sum, max_sum);
//         }
//         return max_sum;
//     }
// }