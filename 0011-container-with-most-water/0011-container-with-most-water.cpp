class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0;
        int r = height.size()-1;
        int ans = -1e9;
        while(l < r) {
            int curr = (r - l) * min(height[l], height[r]);
            if(curr > ans) {
                ans = curr;
            }
            if(height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
};