class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(rows[i] == true) {
                for(int j=0; j<m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0; i<m; i++) {
            if(cols[i] == true) {
                for(int j=0; j<n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }
}