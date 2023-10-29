class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ans;
        if(s.length() < 10) {
            return ans;
        }
        int i = 0;
        int j = 9;
        map<string,int> m;
        
        while(j < s.length()) {
            string t = s.substr(i, j-i+1);
            if(m.find(t) != m.end() && m[t] == 1) {
                ans.push_back(t);
            }
            m[t]++;
            i++;
            j++;
        }
        
        return ans;
    }
};