class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0; // keep track of unique
        for(int j=1; j<nums.size(); j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1; // this equals the no of unique elements
    }
};

/*      
set<int> s;
for(int i=0; i<nums.size(); i++) {
    s.insert(nums[i]);
}

int k = s.size();
int i = 0;
for(auto n: s) {
    nums[i] = n;
    i++;
}

return k; 
*/