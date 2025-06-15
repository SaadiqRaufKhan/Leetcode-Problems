class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1]; // dp[i] -> can 'i' length be formed, dp[n] -> final answer
        dp[0] = true;   // len=0 can always be made by not choosing any of the strings
        for(int len=1; len<=n; len++) {
            for(int i = 0; i<len; i++) {
                if(dp[i] == true && wordDict.contains(s.substring(i, len))) {
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

/* recursive approach
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;

        if(s.length() == 0) return false;

        for(int i=1; i<=s.length(); i++) {
            if(wordDict.contains(s.substring(0, i))) {
                if(wordBreak(s.substring(i, s.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
 */