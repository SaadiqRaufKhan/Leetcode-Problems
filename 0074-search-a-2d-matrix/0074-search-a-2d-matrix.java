class Solution {
    boolean binarySearch(int[] arr, int s, int e, int target) {
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(target == arr[mid]) {
                return true;
            }
            else if(target < arr[mid]) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return false;
    }


    // find the row using binary search logic
    boolean binarySearch2D(int[][] matrix, int s, int e, int target) {
        int n = matrix[0].length;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
                // now find in this row
                return binarySearch(matrix[mid], 0, n-1, target);
            }
            else if (target < matrix[mid][0]) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row, then find the element
        int m = matrix.length;      // rows
        int n = matrix[0].length;   // cols

        return binarySearch2D(matrix, 0, m-1, target);

        
    }
}