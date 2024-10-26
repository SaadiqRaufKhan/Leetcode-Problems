class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        // cycle sort
        
        int i = 0;
        int n = nums.length;
        
        // isPleaced[i] -> element with value 'i' is palced at the correct spot
        boolean[] isPlaced = new boolean[n];  // uninitialized: set all to false
        
        while(i < n) {
            if(nums[i] == i+1 || isPlaced[nums[i]-1]) {    // ignore case
                isPlaced[nums[i]-1] = true;     // if it is not alread true 
                i++;
            }
            else {      // swap case
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;    // places at correct index
                isPlaced[temp-1] = true;
                System.out.println(temp + " placed at correct index");
            }
        }
        
        // do linear search on isPlaced
        for(int j=0; j<n; j++) {
            if(!isPlaced[j]) {
                res.add(j+1);
            }
        }
        
        return res;
    }
}