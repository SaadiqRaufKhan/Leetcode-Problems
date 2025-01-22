class Solution {
    public int uniquePaths(int m, int n) {
        // similar to total no of ways to arrange downs and rights
        int N = n + m - 2;
        int r = m - 1; 
        long res = 1;
        
        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;
        return (int)res;
    }
}