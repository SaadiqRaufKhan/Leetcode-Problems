class Solution {
public:
    void printmat(vector<vector<int>> matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                cout << matrix[i][j] << " ";
            }
            cout << endl;
        }
    }
    // Space complexity wise:
    // O(mn) approach -> create copy of matrix
    // O(m+n) approach -> create 2 sets for i & j
    // O(1) approach -> 2 pass
    void setZeroes(vector<vector<int> >& matrix) {
        printmat(matrix);
        int m = matrix.size(); // #rows
        int n = matrix[0].size(); // #cols
        cout << m << " " << n << endl;
        
        // extra variable for the 0th column
        int col0 = 1;
        // Step 1: Traverse the matrix and mark 1st row & col accordingly:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark i-th row:
                    matrix[i][0] = 0;

                    // mark j-th column:
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        
        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // only need to modify the non-zero entries
                if (matrix[i][j] != 0) { 
                    // check for col & row:
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        //step 3: Finally mark the 0th col & then 0th row:
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        printmat(matrix);
        cout << "col0 = " << col0 << endl;
        // /* ------------------------------------------
        if (col0 == 0) {
            for (int i = 0; i <m; i++) {
                matrix[i][0] = 0;
            }
        }
        printmat(matrix);
        // ------------------------------------------ */ 
    }
};