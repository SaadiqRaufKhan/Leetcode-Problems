class Solution {
public:
    vector<int> countBits(int n) {
        int power = 1;
        int diff = 1;
        vector<int> ans(n+1);

        for(int i=1; i<=n; i++) {
            if((double)i == pow(2, power)){
                power++;
                diff = (int)pow(2, power-1);
            }
            ans[i] = 1 + ans[i-diff];
        }
        return ans;
    }
};