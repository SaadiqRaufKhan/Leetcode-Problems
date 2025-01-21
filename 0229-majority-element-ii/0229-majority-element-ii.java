class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // a, b are the possible answers
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int counta = 0;
        int countb = 0;

        for(int i=0; i<nums.length; i++) {
            if(counta == 0) {
                if(nums[i] == b) {
                    countb++;
                }
                else {
                    a = nums[i];
                    counta++;
                }
            }
            else if(countb == 0) {
                if(nums[i] == a) {
                    counta++;
                }
                else {
                    b = nums[i];
                    countb++;
                }
            }
            else if(nums[i] == a) {
                counta++;
            }
            else if(nums[i] == b) {
                countb++;
            }
            else {
                counta--;
                countb--;
            }
        }

        // verification phase
        int target = (int)Math.floor(nums.length / 3);
        System.out.println(target + ".....");
        int f1 = 0;
        int f2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == a) f1++;
            if(nums[i] == b) f2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(f1 > target) ans.add(a);
        if(f2 > target) ans.add(b);

        return ans;
    }
}