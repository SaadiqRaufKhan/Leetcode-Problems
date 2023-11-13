bool compare(char a, char b) {
    return (a-'A' < b-'A');
}

class Solution {
public:
    string sortVowels(string s) {
        vector<char> v;
        vector<int> idx;
        string vow = "aeiouAEIOU";
        for(int i=0; i<s.length(); i++) {
            if(vow.find(s[i]) != string::npos) {
                v.push_back(s[i]);
                idx.push_back(i);
            }
        }
        
        sort(v.begin(), v.end(), compare);
        int j = 0;
        for(auto i: idx) {
            s[i] = v[j++];
        }
        return s;
    }
};