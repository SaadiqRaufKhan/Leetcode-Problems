class Solution {
    int binarySearch(int[] arr, int s, int e, int target) {
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target < arr[mid]) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return -1;
    }


    // find the row using binary search logic
    int findRow(int[][] matrix, int s, int e, int target) {
        int n = matrix[0].length;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
                return mid;
            }
            else if (target < matrix[mid][0]) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row, then find the element
        int m = matrix.length;      // rows
        int n = matrix[0].length;   // cols

        // System.

        int row = findRow(matrix, 0, m-1, target);

        System.out.println("row = " + row);

        if(row == -1) return false;

        int index = binarySearch(matrix[row], 0, matrix[row].length-1, target);

        System.out.println("index = " + index);

        if(index == -1) return false;

        return true;

        
    }
}