class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        vector<pair<int,int>> dir = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0, 1}, {1,-1}, {1,0}, {1,1}};
        int m = img.size();
        int n = img[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int sum = img[i][j];
                int count = 1;
                for(auto [dx,dy]: dir) {
                    int x = i + dx;
                    int y = j + dy;
                    if(x >= 0 && x < m && y >= 0 && y < n) {
                        sum += img[x][y];
                        count++;
                    }
                }
                int avg = sum/count;
                ans[i][j] = avg;
            }
        }
        return ans;
    }
};