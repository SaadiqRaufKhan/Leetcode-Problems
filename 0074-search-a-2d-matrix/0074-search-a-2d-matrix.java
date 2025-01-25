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

    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        int n = matrix[0].length;
        // find the correct row
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
}