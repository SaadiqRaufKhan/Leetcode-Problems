class Solution {
public:
    const int mod = 1e9 + 7;
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        stack<int> s;
        vector<int> ps(n);
        vector<int> ns(n);

        for(int i=0; i<n; i++) {
            if(s.empty()) {
                ps[i] = -1;
            }
            else {
                while(!s.empty() && arr[s.top()] > arr[i]) {
                    s.pop();
                }
                if(s.empty()) ps[i] = -1;
                else ps[i] = s.top();
                
            }
            s.push(i);
        }

        while(!s.empty()) s.pop();
        for(int i=n-1; i>=0; i--) {
            if(s.empty()) {
                ns[i] = -1;
            }
            else {
                while(!s.empty() && arr[s.top()] >= arr[i]) {
                    s.pop();
                }
                if(s.empty()) ns[i] = -1;
                else ns[i] = s.top();
            }
            s.push(i);
        }

        long long ans = 0;
        for(int i=0; i<n; i++) {
            int lb = (ps[i] == -1) ? 0 : ps[i] + 1;
            int rb = (ns[i] == -1) ? n-1 : ns[i] - 1;

            int llen = i - lb;
            int rlen = rb - i;

            long long temp = (1 + llen + rlen + (llen * rlen)) % mod;
            temp *= arr[i];
            ans = (ans + temp) % mod;
        }

        return (int)ans;

    }
};