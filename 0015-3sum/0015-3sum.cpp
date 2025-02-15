#include <algorithm>
class Solution {
public:
    vector<vector<int> > threeSum(vector<int>& nums) {
        vector<vector<int> > result;
        // 1. sort the complete array
        sort(nums.begin(), nums.end());

        // 2. Pick one element and iterate over the remaining array 
        for(int i=0; i<nums.size()-2; i++) {
            // IMP: break case -> since the array is sorted, we can't make it zero by searching after a +ve number
            if(nums[i] > 0) {
                break;
            }
            // if the current no is same as the previous then ignore it because we need unique solutions
            if(i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int start = i+1; // points to start
            int end = nums.size()-1;    // points to end

            while(start < end) {
                int leftNumber = nums[start];
                int rightNumber = nums[end];
                int sum = nums[i] + leftNumber + rightNumber;
                if(sum == 0) {
                    vector<int> triplet {nums[i], nums[start], nums[end]};
                    result.push_back(triplet);

                    // skip the same nos from both ends of the array to avoid duplicate triplets
                    while(start < end && nums[start] == leftNumber) {
                        start++;    // increment start untill a new number is found

                    }
                    while(start < end && nums[end] == rightNumber) {
                        end--;      // decrement end untill a new number is found
                    }
                }
                else if(sum > 0) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return result;
    }
};