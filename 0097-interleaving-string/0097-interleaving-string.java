class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if(l1 + l2 != l3) return false;

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;    // both empty strings

        // i,j represents the considered lengths
        for(int i=0; i<=l1; i++) {
            for(int j=0; j<=l2; j++) {
                if(i == 0 && j == 0) {  // both empty strings
                    dp[i][j] = true;
                }
                else if(i == 0 && j != 0) { // only s1 empty
                    dp[i][j] = (s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[i][j-1];
                    // dp[i][j] = (s2.substring(0,j)).equals(s3.substring(0,j));
                }
                else if(i != 0 && j == 0) { // only s2 empty
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[i-1][j];
                    // dp[i][j] = (s1.substring(0,i)).equals(s3.substring(0,i));
                }
                else {  // both non-empty
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}

/* Recursive solution
class Solution {
    boolean helper(String s1, int i, String s2, int j, String s3, int k) {
        if(k == s3.length()) {
            return true;
        }

        if(i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
 
        // char match
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        char c3 = s3.charAt(k);

        // only one char match
        if(c1 == c3 && c2 != c3) {
            return helper(s1, i+1, s2, j, s3, k+1);
        }
        else if(c1 != c3 && c2 == c3) {
            return helper(s1, i, s2, j+1, s3, k+1);
        }
        // both char match
        else if(c1 == c3 && c2 == c3) {
            return helper(s1, i+1, s2, j, s3, k+1)
                  || helper(s1, i, s2, j+1, s3, k+1);
        }
        // none of the char matched
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, 0, s2, 0, s3, 0);
    }
}
*/