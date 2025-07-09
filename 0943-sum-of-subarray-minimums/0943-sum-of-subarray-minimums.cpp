class Solution {
public:
    const int mod = 1e9 + 7;
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        stack<pair<int,int>> s;
        vector<int> ps(n);
        vector<int> ns(n);

        for(int i=0; i<n; i++) {
            if(s.empty()) {
                ps[i] = -1;
                s.push({arr[i], i});
            }
            else {
                while(!s.empty() && s.top().first > arr[i]) {
                    s.pop();
                }
                if(s.empty()) {
                    ps[i] = -1;
                    s.push({arr[i], i});
                }
                else {
                    ps[i] = s.top().second;
                    s.push({arr[i], i});
                }
            }
        }

        while(!s.empty()) s.pop();
        for(int i=n-1; i>=0; i--) {
            if(s.empty()) {
                ns[i] = -1;
                s.push({arr[i], i});
            }
            else {
                while(!s.empty() && s.top().first >= arr[i]) {
                    s.pop();
                }
                if(s.empty()) {
                    ns[i] = -1;
                    s.push({arr[i], i});
                }
                else {
                    ns[i] = s.top().second;
                    s.push({arr[i], i});
                }
            }
        }

        for(int i=0; i<n; i++) {
            cout << ps[i] << ", ";
        }
        cout << endl;
        for(int i=0; i<n; i++) {
            cout << ns[i] << ", ";
        }
        cout << endl;

        long long ans = 0;
        for(int i=0; i<n; i++) {
            int lb = (ps[i] == -1) ? 0 : ps[i] + 1;
            int rb = (ns[i] == -1) ? n-1 : ns[i] - 1;

            int llen = i - lb;
            int rlen = rb - i;

            long long temp = (1 + llen + rlen + (llen * rlen)) % mod;
            temp *= arr[i];
            cout << temp << endl;
            ans = (ans + temp) % mod;
        }

        return (int)ans;

    }
};