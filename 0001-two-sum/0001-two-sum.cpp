#include <unordered_set>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for(int i=0; i<nums.size()-1; i++) {
            for(int j=i+1; j<nums.size(); j++) {
                if(nums[i] + nums[j] == target) {
                    result.push_back(i);
                    result.push_back(j);
                    break;
                }
            }
        }
        return result;
        // vector<int> result;
        // unordered_set<int> uset;
        
        // for(int i=0; i<nums.size(); i++) {
        //     int pair = target - nums[i];
        //     unordered_set<int> :: iterator itr = uset.find(pair);
        //     // If we found a pair then get it's index and push the indices in the result vector
        //     if(itr != uset.end()) {
        //         int idx = 0;
        //         while(nums[idx] != *itr) {
        //             idx++;
        //         }
        //         result.push_back(i);
        //         result.push_back(idx);
        //     }
        //     // otherwise just insert into set
        //     uset.insert(nums[i]);
        // }
        // return result;

    }
};




 //        vector<int> result;
//         unordered_set<int> uset;

//         for(int i=0; i<nums.size(); i++) {
//             int pair = target - nums[i];
            
//             if(uset.find(pair) != uset.end()) {
//                 result.push_back(pair);
//                 result.push_back(nums[i]);
//             }

//             uset.insert(nums[i]);
//         }

//         return result;


