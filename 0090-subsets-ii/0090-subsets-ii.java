class Solution {
    public void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> temp) {
        res.add(temp);
        
        for(int i=pos; i<nums.length; i++) {
            if(i == pos || nums[i] != nums[i-1]) {
                temp.add(nums[i]);
                helper(nums, i+1, res, new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, res, temp);
        return res;
    }
}