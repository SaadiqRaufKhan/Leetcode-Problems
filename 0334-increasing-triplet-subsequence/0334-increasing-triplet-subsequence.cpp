class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        
        int smallest = nums[0];
        left[0] = smallest;
        for(int i=1; i<n; i++) {
            left[i] = smallest;
            smallest = min(smallest, nums[i]);
        }
        
        int largest = nums[n-1];
        right[n-1] = largest;
        for(int i=n-1; i>=0; i--) {
            right[i] = largest;
            largest = max(largest, nums[i]);
        }
        
        for(int i=1; i<n-1; i++) {
            if(left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }
        return false;
    }
};