class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        
        while(s <= e) {
            int mid = s + (e - s)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            // mid on line 1
            if(nums[mid] >= nums[s]) {
                // go left
                if(target < nums[mid] && target >= nums[s]) {
                    e = mid - 1;
                }
                else { // go right
                    s = mid + 1;
                }
            }
            else { // mid on line 2
                if(target <= nums[e] && target > nums[mid]) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}