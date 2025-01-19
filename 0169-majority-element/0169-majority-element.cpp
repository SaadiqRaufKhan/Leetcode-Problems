class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 1;
        int maj = INT_MAX;
        
        for(auto n: nums) {
            if(maj != n) {
                count--;
                if(count == 0) {
                    maj = n;
                    count++;
                }
            }
            else {
                count++;
            }
        }
        return maj;
    }

};