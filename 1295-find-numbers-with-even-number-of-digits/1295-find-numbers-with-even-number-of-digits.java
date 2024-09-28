class Solution {
    boolean isEven(int n) {
        int d = 0;
        while(n > 0) {
            n /= 10;
            d++;
        }
        return (d % 2 == 0);
    }
    
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(isEven(nums[i])) count++;
        }
        return count;
    }
}