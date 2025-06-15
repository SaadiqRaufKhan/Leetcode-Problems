class Solution {
    int decode(char c) {
        return c - '1' + 1;
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1) return decode(s.charAt(n-1)) != 0 ? 1 : 0;

        int[] dp = new int[n];

        int d1 = decode(s.charAt(n-1));
        int d2 = decode(s.charAt(n-2));
        // initialize the last two cells
        if(d1 == 0) {
            dp[n-1] = 0;
            if(d2 == 0 || d2 >= 3) dp[n-2] = 0;
            else if(d2 == 2 || d2 == 1) dp[n-2] = 1;
        }
        else {
            dp[n-1] = 1;
            if(d2 == 0) dp[n-2] = 0;
            else {
                if(d2*10 + d1 <= 26) dp[n-2] = 2;
                else dp[n-2] = 1;
            }
        }

        // fill the remaining dp array
        for(int i=n-3; i>=0; i--) {
            d1 = decode(s.charAt(i+1));
            d2 = decode(s.charAt(i));
            int sum = d2*10 + d1;
            if(d2 == 0) {
                dp[i] = 0;
            }
            else if(d1 == 0) {
                if(sum <= 26) dp[i] = dp[i+2];
                else dp[i] = 0;
            }
            else {
                if(sum <= 26) dp[i] = dp[i+1] + dp[i+2];
                else dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
}