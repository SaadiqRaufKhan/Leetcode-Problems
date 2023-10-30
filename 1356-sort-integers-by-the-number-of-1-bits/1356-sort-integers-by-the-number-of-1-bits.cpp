int countSet(int a) {
    int ans = 0;
    while(a != 0) {
        if(a & 1) ans++;
        a = a >> 1;
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