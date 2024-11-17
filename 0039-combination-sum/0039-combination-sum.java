class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(candidates, 0, target, ans, new ArrayList<Integer>());
        
        return ans;
    }
    
    void helper(int[] arr, int i, int target, List<List<Integer>> ans, ArrayList<Integer> aux) {
        if(target == 0) {
            ans.add(aux);
            return;
        }
        if(i == arr.length) return;
        
        // exclude the element at i & just increment i
        helper(arr, i+1, target, ans, new ArrayList<Integer>(aux));
        
        // include the element at i & don't increment i (because it can be used multiple times in later iterations)
        if(arr[i] <= target) {
            aux.add(arr[i]);
            helper(arr, i, target-arr[i], ans, new ArrayList<Integer>(aux));
        }
        
        
    }
}