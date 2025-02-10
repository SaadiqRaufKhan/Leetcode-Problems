class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int currFreq = 0;
        int currElem = nums[0];
        int k = 0;      // this acts as the correct index 
        int i = 0;
        while(i < nums.size()) {
            if(nums[i] == currElem) {
                currFreq++;
                if(currFreq <= 2) {
                    nums[k] = nums[i];
                    k++;
                    i++;
                }
                else {
                    i++;
                }
            }
            else {
                nums[k] = nums[i];
                currElem = nums[i];
                currFreq = 1;
                k++;
                i++;
            }
        }
        return k;
    }
};