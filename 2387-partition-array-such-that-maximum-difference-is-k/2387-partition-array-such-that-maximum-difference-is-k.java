class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int partitions = 0;

        int i = 0;
        while(i < n) {
            int j = i;
            int num = nums[j];
            while(j < n && nums[j] - num <= k) {
                j++;
            }
            partitions++;
            i = j;
        }
        return partitions;
    }

}