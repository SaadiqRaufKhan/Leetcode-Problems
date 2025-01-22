class Solution {
    public int uniquePaths(int m, int n) {
        // similar to total no of ways to arrange downs and rights
        int N = n + m - 2;
        int r = m - 1; 
        long res = 1;
        // (n+m-2) C (m-1)
        for (int i = 1; i <= m-1; i++)
            res = res * (n - 1 + i) / i;
        return (int)res;
    }
}