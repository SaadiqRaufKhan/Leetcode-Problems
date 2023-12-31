class Solution {
public:
    int lowerBound(vector<int>& nums, int target) {
        int s = 0;
        int e = nums.size()-1;
        
        int ans = -1;
        
        while(s <= e) {
            int mid = s + (e-s)/2;  // avoids integer overflow
            if(nums[mid] == target) {
                // don't return ans now and continue to search on the left side 
                // update e to check for more occurence of target
                ans = mid;
                e = mid-1;  
            }
            else if(nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        
        return ans;
    }
    int upperBound(vector<int>& nums, int target) {
        int s = 0;
        int e = nums.size()-1;
        
        int ans = -1;
        
        while(s <= e) {
            int mid = s + (e-s)/2;  // avoids integer overflow
            if(nums[mid] == target) {
               // don't return ans now and continue to search on the right side 
                // update s to check for more occurence of target
                ans = mid;
                s = mid+1;  
            }
            else if(nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        
        return ans;
    }
    // Pure BS
    vector<int> searchRange(vector<int>& nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        return {lb, ub};
    }
    
    
    // BS + Linear
    /*
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans = {-1,-1};

        int s = 0, e = nums.size()-1; 
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                int first = mid;
                int last = mid;
                while(first >= 0 && nums[first] == target) {
                    first--;
                }
                while(last < nums.size() && nums[last] == target) {
                    last++;
                }
                ans[0] = first+1;
                ans[1] = last-1;
                break;
            }
            else if(nums[mid] > target) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        return ans;
    }*/
};