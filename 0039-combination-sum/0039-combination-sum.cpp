class Solution {
public:
    void combinationSumHelper(vector<int>& candidates, int pos, int target, vector<vector<int>> &ans, vector<int> &a) {
        // base cases
        // we'll always reach the end of array by excluding elements
        if(target == 0){
            ans.push_back(a);
            return;
        }
        if(pos == candidates.size()) {
            return;
        }

        // include curr element on this condition
        if(candidates[pos] <= target) {
            // push curr elem to vector for including it
            a.push_back(candidates[pos]);
            // recursive call by including it
            combinationSumHelper(candidates, pos, target-candidates[pos], ans, a);
            // remove curr elem after it has served it purpose 
            a.pop_back();
        }

        // exclude curr element
        combinationSumHelper(candidates, pos+1, target, ans, a);

    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> a;
        combinationSumHelper(candidates, 0, target, ans, a);
        return ans;
    }
};