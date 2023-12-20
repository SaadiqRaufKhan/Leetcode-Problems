class Solution {
public:
// alt approach could be to use stack 
    string reverseWords(string s) {
        stack<string> st;
        string word = "";
        for(int i=0; i<s.size(); i++) {
            char c = s[i];
            if(c == ' ') {
                if(word.size() != 0) {
                    st.push(word);
                    word = "";
                }
            }
            else {
                word.push_back(c);
            }
        }
        if(word.size() != 0) {
            st.push(word);
            word = "";
        }
        string ans = "";
        while(!st.empty()) {
            ans += st.top();
            ans += " ";
            st.pop();
        }
        ans.pop_back();
        return ans;
    }
};

















//         vector<vector<char>> words;
//         vector<char> w;
//         for(int i=0; i<s.length(); i++) {
//             if(s[i] == ' ' || i == s.length()-1) {
//                 if(i == s.length()-1 && s[i] != ' ') {
//                     w.push_back(s[i]);
//                 }
//                 if(w.size() > 0) {
//                     words.push_back(w);
//                     w.clear();
//                     continue;
//                 }
//                 continue;
//             }
//             w.push_back(s[i]);
//         }

//         // now we have all the words in the vector -> reverse as a whole, this will change the order of the words
//         reverse(words.begin(), words.end());

//         // pick each word, embed in a new string, add spaces and return that string
//         string ans;
//         for(auto word: words) {
//             for(auto ch: word) {
//                 ans += ch;
//             }
//             ans += " ";
//         }
//         // taking substring to remove the " " at the end
//         return ans.substr(0, ans.size()-1);