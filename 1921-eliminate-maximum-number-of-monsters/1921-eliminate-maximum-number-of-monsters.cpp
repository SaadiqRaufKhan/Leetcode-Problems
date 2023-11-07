class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        int n = dist.size();
        vector<int> time(n);
        // calculate the time at which their dist will be zero
        for(int i=0; i<n; i++) {
            double t = (double)dist[i]/(double)speed[i];
            int x = (int)(ceil(t));
            time[i] = x;
        }
        // sort by that time
        sort(time.begin(), time.end());

        // increment ans as long as currTime is less than the time at which monsters reach dist zero
        int ans = 0;
        int currTime = 0;

        for(int i=0; i<n; i++) {
            if(currTime >= time[i]) break;
            currTime++;
            ans++;
        }
        return ans;
    }
};