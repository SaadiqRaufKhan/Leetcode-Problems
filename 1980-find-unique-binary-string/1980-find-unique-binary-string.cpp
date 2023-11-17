class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        string res = "";
        int n = nums.size();
        for(int i=0; i<n; i++) {
            string s = nums[i];
            char c = s[i];
            cout << "c = " << c << endl;
            if(c == '0') res.push_back('1');
            else res.push_back('0');
        }
        return res;
    }
};