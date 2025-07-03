class Solution {
public:
    int lengthOfLongestSubstring(string s) {


        // unordered_map<char,int> umap;   // character, index
        // int start = 0; 
        // int end = 0;
        // int maxLen = 0;

        // while(end < s.length()) {
        //     char curr_ch = s[end];

        //     // check if the curr_ch is already in the map or not and if it's index is greater than or equal to the start of the current window
        //     if(umap.find(curr_ch) != umap.end() && umap[curr_ch] >= start) {
        //         // already present case -> start new window 
        //         // new starting posn. = k + 1
        //         start = umap[curr_ch] + 1;
        //     }
        //     // general case (also includes the case for not present)
        //     umap[curr_ch] = end;      // insert/update start for curr_ch
        //     end++;                    // goto next char

        //     maxLen = max(maxLen, end-start);
        // }

        // return maxLen;

        unordered_set<int> uset;
        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end < s.length()) {
            if(uset.find(s[end]) == uset.end()) {
                uset.insert(s[end]);
                end++;
            }
            else {
                while(start < end && s[start] != s[end]) {
                    uset.erase(s[start++]);
                }
                start++;
                end++;
            }
            maxLen = max(maxLen, end - start);

        }

        return maxLen;

    }

};

