class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int n = nums.size();
        cout << "size = " << n << endl;
        if(n < 2) return 1;
        if(n == 2) {
            return (nums[0] == nums[1]) ? 1 : 2;
        }
        
        vector<int> diff(n-1);
        for(int i=1; i<n; i++) {
            diff[i-1] = nums[i] - nums[i-1];
        }
        int ans = n;
        
        int consPos = 0;    // consective +ve
        int consNeg = 0;    // consective -ve
        int zeroCount = 0;  // count of zeroes (not in between cons +ve/-ve)
        int i = 0;
        while(i<diff.size()) {
            if(diff[i] < 0) {
                int j = i+1;
                while(j < diff.size() && diff[j] <= 0) {
                    consNeg++;
                    j++;
                }
                i = j;
            }
            else if (diff[i] > 0){
                int j = i+1;
                while(j < diff.size() && diff[j] >= 0) {
                    consPos++;
                    j++;
                }
                i = j;
            }
            else {
                zeroCount++;
                i++;
            }
        }
        cout << "diff = [ ";
        for(auto d: diff) {
            cout << d << " ";
        }
        cout << "]" << endl;
        cout << "consPos = " << consPos << endl;
        cout << "consNeg = " << consNeg << endl;
        cout << "zeroCount = " << zeroCount << endl;
        
        ans = ans - (consPos + consNeg + zeroCount);
        cout << "ans = " << ans << endl;
        
        return ans;
    }
};