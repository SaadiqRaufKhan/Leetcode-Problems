class Solution {
public:
    // Approach 1:
//     vector<int> findArray(vector<int>& pref) {
//         vector<int> arr(pref.size());
//         arr[0] = pref[0];
        
//         for(int i=1; i<pref.size(); i++) {
//             arr[i] = pref[i] ^ pref[i-1];
//         }
        
//         return pref;
//     }
    
    // Approach 2: Space optimized
    vector<int> findArray(vector<int>& pref) {
        for(int i=pref.size()-1; i>0; i--) {
            pref[i] = pref[i] ^ pref[i-1];
        }
        
        return pref;
    }
};