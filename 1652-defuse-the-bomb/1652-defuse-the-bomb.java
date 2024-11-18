class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        
        if(k == 0) {
            for(int i=0; i<n; i++) {
                ans[i] = 0;
            }
        }
        else if(k > 0) {
            for(int i=0; i<n; i++) {
                int sum = 0;
                for(int j=1; j<=k; j++) {
                    int idx = (i + j) % n;
                    sum += code[idx];
                }
                ans[i] = sum;
            }
        }
        else {
            k = k * -1;
            for(int i=0; i<n; i++) {
                int sum = 0;
                for(int j=1; j<=k; j++) {
                    int idx = (n + i - j) % n;
                    sum += code[idx];
                }
                ans[i] = sum;
            }
        }
        
        return ans;
    }
}