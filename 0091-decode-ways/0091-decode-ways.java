class Solution {
    int decode(char c) {
        return c - '1' + 1;
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 1) return decode(s.charAt(n-1)) != 0 ? 1 : 0;

        int[] dp = new int[n];

        int d1 = decode(s.charAt(n-1));     // 1s place
        int d10 = decode(s.charAt(n-2));    // 10s place
        // initialize the last two cells
        if(d1 == 0) {
            dp[n-1] = 0;
            if(d10 == 0 || d10 >= 3) dp[n-2] = 0;
            else if(d10 == 2 || d10 == 1) dp[n-2] = 1;
        }
        else {
            dp[n-1] = 1;
            if(d10 == 0) dp[n-2] = 0;
            else {
                if(d10*10 + d1 <= 26) dp[n-2] = 2;
                else dp[n-2] = 1;
            }
        }

        // fill the remaining dp array going right to left, dp[0] will contain the final answer
        // logic can be understood by drawing the dp array and running examples
        for(int i=n-3; i>=0; i--) {
            d1 = decode(s.charAt(i+1)); // 1s place
            d10 = decode(s.charAt(i));  // 10s place
            int sum = d10*10 + d1;
            if(d10 == 0) {
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