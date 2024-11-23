class Solution {
public:
	int longestCommonSubsequence(string s, string t) {
		int m = s.size();
		int n = t.size();

        vector<vector<int>> output(m+1, vector<int>(n+1, 0));

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				// Check if 1st char matches: note the indices 
				if(s[i-1] == t[j-1]) {
					output[i][j] = 1 + output[i-1][j-1];
				}
				else {
                    output[i][j] = max(output[i-1][j], output[i][j-1]);
				}
			}
		}
		return output[m][n];
	}
};