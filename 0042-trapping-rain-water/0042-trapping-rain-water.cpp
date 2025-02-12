class Solution {
public:
    int trap(vector<int>& height) {
        int len = height.size();
        // base case
        if(len <= 2) {
            return 0;
        }

        int *leftMaxTillNow = new int[len];
        int *rightMaxTillNow = new int[len];
        int lMax = 0;
        int rMax = 0;
        // update left array
        for(int i=0; i<len; i++) {
            if(height[i] > lMax) {
                lMax = height[i];
            }
            leftMaxTillNow[i] = lMax;
        }
        // update right array
        for(int i=len-1; i>=0; i--) {
            if(height[i] > rMax) {
                rMax = height[i];
            }
            rightMaxTillNow[i] = rMax;
        }   

        int totalWater = 0;
        for(int i=0; i<len; i++) {
            int minHeight = min(leftMaxTillNow[i], rightMaxTillNow[i]);
            int curr_water = minHeight - height[i];
            totalWater += curr_water;
        }

        return totalWater;
    }
};