class Solution {
public:
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
    }
};