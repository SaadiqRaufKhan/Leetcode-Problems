class Solution {
public:
    bool checkArithmetic(vector<int> v) {
        bool flag = true;
        if(v.size() >= 2) {
            sort(v.begin(), v.end());
            cout << "V is: ";
            for(auto it: v) cout << it << " ";
            cout << endl;
            
            int d = v[1] - v[0];
            for(int i=2; i<v.size(); i++) {
                if(v[i] - v[i-1] != d) {
                    flag = false;
                    break;
                }
            }
        }
        else {
            flag = true;
        }
        return flag;
    }
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        vector<bool> ans;
        for(int i=0; i<l.size(); i++) {
            vector<int> v(nums.begin()+l[i], nums.begin()+(r[i]+1));
            bool res = checkArithmetic(v);
            ans.push_back(res);
        }
        return ans;
    }
};