class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int totalGroups = n / 3;

        Arrays.sort(nums);

        int[][] ans = new int[totalGroups][3];

        int row = 0;
        int groups = 0;
        while (row < totalGroups) {
            int col = 0;
            int num = nums[row*3 + col];
            int size = 0;
            while(col < 3 && nums[row*3 + col] - num <= k) {
                ans[row][col] = nums[row*3 + col];
                col++;
                size++;
            }
            row++;
            if(size == 3) {
                groups++;
            }
            else {
                return new int[][] {};
            }
        }

        return (groups == totalGroups) ? ans : new int[][] {};
    }
}