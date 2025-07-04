class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[n];

        int ps = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            ps += nums[i];
            prefixSum[i] = ps;
            if(ps == k) ans++;
            int diff = ps - k;
            if(map.containsKey(diff)) {
                ans += map.get(diff);
            }
            map.put(ps, map.getOrDefault(ps, 0) + 1);
        }

        return ans;
    }
}