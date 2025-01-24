class Solution {
public:
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.size() == 0) {
            return false;
        }

        int m = matrix.size();      // rows
        int n = matrix[0].size();   // cols

        // indices of elements if treated as a 1D array
        // we have to use '/' & '%' to find the actual indices
        int low = 0;
        int high = (m * n) - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(matrix[mid / n][mid % n] == target) {
                return true;
            }
            if(matrix[mid / n][mid % n] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
};