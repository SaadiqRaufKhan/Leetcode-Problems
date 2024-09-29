class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ceil = findCeil(nums, target);
        int floor = findFloor(nums, target);
        
        if(ceil == -1 || floor == -1) {
            return new int[] {-1, -1};
        }
        return new int[] {floor, ceil};
        
    }
    int findCeil(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int ceil = -1;
        
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(nums[mid] == target) {
                l = mid + 1;
                ceil = mid;
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ceil; 
        
    }
    int findFloor(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int floor = -1;
        
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(nums[mid] == target) {
                r = mid - 1;
                floor = mid;
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return floor;
        
        
    }
}