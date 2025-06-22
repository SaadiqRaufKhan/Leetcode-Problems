class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        List<Integer> ans = new ArrayList<>();

        while(ans.size() < m * n) {
            // move right along the up wall
            for(int i=left; i<=right; i++) {
                ans.add(matrix[up][i]);
            }
            if(ans.size() == m * n) return ans;
            up++;

            // move down along the right wall
            for(int i=up; i<=down; i++) {
                ans.add(matrix[i][right]);
            }
            if(ans.size() == m * n) return ans;
            right--;

            // move left along the down wall
            for(int i=right; i>=left; i--) {
                ans.add(matrix[down][i]);
            }
            if(ans.size() == m * n) return ans;
            down--;

            // move up along the left wall
            for(int i=down; i>=up; i--) {
                ans.add(matrix[i][left]);
            }
            if(ans.size() == m * n) return ans;
            left++;
        }
        return ans;

    }
}