class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int m = matrix.size();      // rows
        int n = matrix[0].size();   // cols

        // first take transpose the matrix
        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {
                if(i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // then reverse each row
        for(int i=0; i<m; i++) {
            reverse(matrix[i].begin(), matrix[i].end());
        }


    }
};