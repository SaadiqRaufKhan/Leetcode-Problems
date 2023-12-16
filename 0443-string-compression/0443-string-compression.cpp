class Solution {
public:
    int compress(vector<char>& chars) {
        string s = "";
        int idx = 0;
        while(idx < chars.size()) {
            char currChar = chars[idx];
            int currCount = 1;
            while(idx+1 < chars.size() && chars[idx+1] == chars[idx]) {
                currCount++;
                idx++;
            }
            idx++;
            s.push_back(currChar);
            if(currCount > 1) s += to_string(currCount);
        }
        int ans = s.length();
        for(int i=0; i<ans; i++) {
            chars[i] = s[i];
        }
        return ans;
    }
};