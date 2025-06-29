bool compare(vector<int> a, vector<int> b) {
    return a[1] < b[1];
}

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        // sort based on end value
        sort(intervals.begin(), intervals.end(), compare);
        // remove greedily
        int prevEnd = intervals[0][1];
        int deleted = 0;
        for(int i=1; i<intervals.size(); i++) {
            // starting point of current interval should be greater than or equal to the end point of previous element for it to be non-overlapping
            if(intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            }
            else {
                deleted++;
            }
        }
        return deleted;
    }
};