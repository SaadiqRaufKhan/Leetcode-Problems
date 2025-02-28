class Solution {
public:

    int search(vector<int> prefixsum, int target, int l, int r) {
        int ans = -1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(prefixsum[mid] <= target) {  // target is max allowed reduction
                ans = mid;                  // so keep searching for other possible answers
                l = mid + 1;                
            }
            else if(prefixsum[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return ans;
    }
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        
        // prepare the prefix sum array
        vector<int> prefixsum(n, 0);
        prefixsum[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        int minLength = INT_MAX;
        // scan prefix sum from left to right and see what can be subtracted from the prefixsum
        for(int i=n-1; i>=0; i--) {
            if(prefixsum[i] >= target) {
                int currLength = i + 1;     // a possible answer is to include the full [0 to i] subarray
                int maxAllowedReduction = prefixsum[i] - target;
                int index = search(prefixsum, maxAllowedReduction, 0, i-1);
                if(index != -1) {           // see if currLength can be trimmed or not
                    currLength -= (index + 1);  // adding 1 to index because currLength was 1+ i
                }
                minLength = min(minLength, currLength);
            }
        }
        return (minLength == INT_MAX) ? 0 : minLength;
    }
};