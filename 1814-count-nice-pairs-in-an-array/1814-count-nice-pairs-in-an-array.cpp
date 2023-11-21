class Solution {
public:
    int nC2(int n) {
        int res = 1;
        if(n % 2 == 0) {
            res *= n/2;
            res *= (n-1);
        }
        else {
            res *= (n-1)/2;
            res *= n;
        }
        return res;
    }
    int rev(int n) {
        string s = to_string(n);
        reverse(s.begin(), s.end());
        return stoi(s);
    }
    int countNicePairs(vector<int>& nums) {
        int mod = 1e9 + 7;
        unordered_map<int,int> m;
        for(int i=0; i<nums.size(); i++) {
            nums[i] = nums[i] - rev(nums[i]);
        }
        
        int res = 0;
        for (int num : nums) {
            res = (res + m[num]) % mod;
            m[num]++;
        }
        
        return res;
    }
};