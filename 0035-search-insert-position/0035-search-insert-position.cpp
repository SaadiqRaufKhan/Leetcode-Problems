class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int s = 0;
        int e = nums.size()-1;
        
        int floor = -1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                e = mid - 1;
            }
            else {
                floor = mid;
                s = mid + 1;
            }
        }
        return floor + 1;
    }
    /*
    int searchInsert(vector<int>& nums, int target) {
        int s = 0;
        int e = nums.size()-1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        // we are returning 's' because the point where 's'
        // passes 'e' is the correct position of target
        return s;
    }*/
};