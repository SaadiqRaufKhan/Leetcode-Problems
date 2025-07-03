record Pair(int i, int sum) {}
class Solution {
    int helper(int i, int sum, int[] nums, int target, Map<Pair, Integer> dp) {
        Pair p = new Pair(i, sum);
        if(dp.containsKey(p)) {
            return dp.get(p);
        }

        if(i == nums.length) {
            if(sum == target) {
                dp.put(p, 1);
                return 1;
            }
            else {
                dp.put(p, 0);
                return 0;
            }
        }

        int ans = helper(i+1, sum + nums[i], nums, target, dp) + helper(i+1, sum - nums[i], nums, target, dp);
        dp.put(p, ans);
        return ans;

    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<Pair, Integer> dp = new HashMap<>();

        return helper(0, 0, nums, target, dp);
    }
}