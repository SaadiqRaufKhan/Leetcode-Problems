class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<bool> res(n, false);
        res[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            for(int j=1; j<=nums[i] && i + j < n; j++) {
                if(res[i+j]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[0];
    }
};