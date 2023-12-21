bool compare(vector<int> a, vector<int> b) {
    return a[0] < b[0];
}
class Solution {
public:
    int maxWidthOfVerticalArea(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), compare);
        int ans = 0;
        for(int i=0; i<points.size()-1; i++) {
            ans = max(ans, points[i+1][0] - points[i][0]);
        } 
        return ans;
    }
};