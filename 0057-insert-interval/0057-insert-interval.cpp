class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> ans;
        int n = intervals.size();
        // if(n == 0) {
        //     ans.push_back(newInterval);
        //     return ans;
        // }
        int i = 0;
        bool inserted = false;
        while(i < n) {
            if(newInterval[1] < intervals[i][0] && !inserted) {
                ans.push_back(newInterval);
                ans.push_back(intervals[i]);
                inserted = true;
                i++;
            }
            else if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                ans.push_back(intervals[i]);
                i++;
            }
            else {
                int s = min(intervals[i][0], newInterval[0]);
                int e = max(intervals[i][1], newInterval[1]);
                int j = i + 1;
                while(j < n && e >= intervals[j][0]) {
                    e = max(e, intervals[j][1]);
                    j++;
                }
                ans.push_back({s,e});
                i = j;
                inserted = true;
            }
        }
        if(!inserted) ans.push_back(newInterval);
        return ans;
    }
};