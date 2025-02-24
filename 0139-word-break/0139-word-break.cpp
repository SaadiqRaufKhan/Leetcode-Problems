class Solution {
public:
    // basic intuition is that we traverse over the length of the string s, and
    // we see if that much length of the string can be made by words in dict or not
    // so there will be 2 loops: one for covering the length of string s
    // and one for traversing over the i-length substring of s    
    
    bool wordBreak(string s, vector<string> &dict) {
        vector<bool> dp(s.size()+1, false);
        dp[0] = true;
        // i & j denote the length
        for(int i=1; i<=s.size(); i++) {
            for(int j=0; j<i; j++) {
                // if a word with length j (0 to j-1) is present
                 if(dp[j]) {
                    // then we need to check if word with length i-j (j to i) is also present or not
                    string word = s.substr(j, i-j);
                    if(find(dict.begin(), dict.end(), word) != dict.end()) {
                        dp[i] = true;   // this i-length substring can be made up
                        break;          // no need for further processing
                    }
                }
            }
        }
        return dp[s.size()];            // check if the whole string can be made up
    }
};
