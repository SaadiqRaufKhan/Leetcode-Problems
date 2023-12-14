class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<int> onesRow(m, 0);
        vector<int> onesCol(n, 0);
        vector<int> zeroRow(m, 0);
        vector<int> zeroCol(n, 0);
        
        vector<vector<int>> res(m, vector<int>(n, 0));
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
                else {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res[i][j] = onesRow[i] + onesCol[j] - zeroRow[i] - zeroCol[j];
            }
        }
        return res;
    }
};