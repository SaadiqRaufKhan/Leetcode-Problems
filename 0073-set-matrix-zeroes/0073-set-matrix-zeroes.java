class Solution {
    public void setZeroes(int[][] matrix) { 
        int n = matrix.length;
        int m = matrix[0].length;

        // we'll make use of the 0th row and col instead of making separate arrays
        // but we'd have to make an extra variable for either 0th-col or 0th-row

        int col0 = 1;   // indicating non-zero value

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    // this will help us to mark the ith row as 0
                    matrix[i][0] = 0;   
                    if(j == 0) {
                        col0 = 0;
                    }
                    else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // only need to modify the non-zero entries
                if (matrix[i][j] != 0) { 
                    // check for col & row:
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        // modify the 0th row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        // modify the 0th col
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         boolean[] rows = new boolean[n];
//         boolean[] cols = new boolean[m];

//         // 1. find rows and cols with 0s in them 
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<m; j++) {
//                 if(matrix[i][j] == 0) {
//                     rows[i] = true;
//                     cols[j] = true;
//                 }
//             }
//         }

//         // 2. fill those rows and cols with 0s
//         for(int i=0; i<n; i++) {
//             if(rows[i] == true) {
//                 for(int j=0; j<m; j++) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//         for(int i=0; i<m; i++) {
//             if(cols[i] == true) {
//                 for(int j=0; j<n; j++) {
//                     matrix[j][i] = 0;
//                 }
//             }
//         }
//     }
// }