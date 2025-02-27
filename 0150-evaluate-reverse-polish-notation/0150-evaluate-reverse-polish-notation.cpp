class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> s;
        for(string t: tokens) {
            if(t == "+") {
                int x = s.top();
                s.pop();
                int y = s.top();
                s.pop();
                s.push(y+x);
            }
            else if(t == "-") {
                int x = s.top();
                s.pop();
                int y = s.top();
                s.pop();
                s.push(y-x);
            }
            else if(t == "*") {
                int x = s.top();
                s.pop();
                int y = s.top();
                s.pop();
                s.push(y*x);
            }
            else if(t == "/") {
                int x = s.top();
                s.pop();
                int y = s.top();
                s.pop();
                s.push(y/x);
            }
            else {
                s.push(stoi(t));
            }
        }
        return s.top();
    }
};