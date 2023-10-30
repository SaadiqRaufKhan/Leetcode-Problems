int countSet(int n) {
    int ans = 0;
    while(n > 0) {
        n = n & (n-1);
        ans++;
    }
    return ans;
}

bool compare(int a, int b) {
    int n1 = countSet(a);
    int n2 = countSet(b);
    
    if(n1 == n2) return a < b;
    
    return n1 < n2;
}

class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        vector<int> res(arr);
        sort(res.begin(), res.end(), compare);
        return res;
    }
};