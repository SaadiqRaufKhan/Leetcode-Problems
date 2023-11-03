class Solution {
public:
    /*
    int expandPalindrome(string s, int l ,int r) {
        if(s.length() == 0 || l > r) {
            return 0;
        }
        // expand left and right boundary
        while(l >= 0 && r < s.length() && s[l] == s[r]) {
            l--;
            r++;
        }
        // we need to subtract 1 because the indices are already more than required because of l-- and r++
        return r - l - 1; 
    }

    string longestPalindrome(string s) {
        if(s.length() == 0) return "";
        // initialize the start & end index for the subtring to be returned, also 'end-start' will give us the length of the current longest substring 
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i+1);

            int currLen = max(len1, len2);
            // if the curr subtring's len is the more than the older substring's len then update the boundary points of the substring to be returned
            if(currLen > end - start) {
                start = i - ((currLen-1)/2); // subtracting a 1 to avoid out of bounds
                end = i + (currLen/2);
            }
        }
        // finally return the substring using the boundary points i.e. end & start
        return s.substr(start, end - start + 1);
    } */

    // DP tabulation (thinking is similar to above)
    string longestPalindrome(string s) {
        int n = s.length();
        // dp[i][j] -> whether the substring from idx 'i' to 'j' is a palindrome or not
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        
        // final starting and ending idx for the longest palindromic substring
        int start=0, end=0;
        
        // single characters(from idx 'i' to 'i') always form a palindrome -> dp[i][i] = true
        // BASE CASE for ODD length palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // If two consecutive characters are same then it is also a palindrome
        // BASE CASE for EVEN length palindromes
        for (int i = 0; i < n-1; i++) {
            if (s[i] == s[i+1]) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        
        // We'll try all possible lengths of substrings that can be formed (3,4,5,...,n), len = 1 and 2 have been taken care of in the base case
        for (int len=3; len<=n; len++) {
            // i = start idx of substring
            for (int i=0; i<=n-len; i++) {
                // j = end idx of substr
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substr(start, end-start+1);
    }
};
