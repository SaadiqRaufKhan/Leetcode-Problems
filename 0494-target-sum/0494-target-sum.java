// // Top-down memoization based recursion
// record Pair(int i, int sum) {}  // tracks the state (index, sum) of the solution
// class Solution {
//     int helper(int i, int sum, int[] nums, int target, Map<Pair, Integer> dp) {
//         Pair p = new Pair(i, sum);
//         if(dp.containsKey(p)) {
//             return dp.get(p);
//         }

//         if(i == nums.length) {
//             if(sum == target) {
//                 dp.put(p, 1);
//                 return 1;
//             }
//             else {
//                 dp.put(p, 0);
//                 return 0;
//             }
//         }

//         int ans = helper(i+1, sum + nums[i], nums, target, dp) + helper(i+1, sum - nums[i], nums, target, dp);
//         dp.put(p, ans);
//         return ans;

//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<Pair, Integer> dp = new HashMap<>();

//         return helper(0, 0, nums, target, dp);
//     }
// }

// bottom-up dp
// public class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         Map<Integer, Integer>[] dp = new HashMap[n + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i] = new HashMap<>();
//         }
//         // base case
//         dp[0].put(0, 1);

//         for (int i = 0; i < n; i++) {
//             for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
//                 int currSum = entry.getKey();
//                 int count = entry.getValue();
//                 dp[i + 1].put(currSum + nums[i], 
//                           dp[i + 1].getOrDefault(currSum + nums[i], 0) + count);
//                 dp[i + 1].put(currSum - nums[i], 
//                           dp[i + 1].getOrDefault(currSum - nums[i], 0) + count);
//             }
//         }
//         return dp[n].getOrDefault(target, 0);
//     }
// }

// bottom up: space optimized
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                nextDp.put(total + num, 
                           nextDp.getOrDefault(total + num, 0) + count);
                nextDp.put(total - num, 
                           nextDp.getOrDefault(total - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}