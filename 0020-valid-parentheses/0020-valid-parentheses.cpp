class Solution {
public:
    bool isValid(string exp) {
        stack<char> s;
        for(int i=0; exp[i] != '\0'; i++) {
            if(exp[i] == '{' || exp[i]=='[' ||exp[i]=='(' ) {
                s.push(exp[i]);
            }
            else if(exp[i] == '}' || exp[i]==']' || exp[i]==')' ) {
                if(s.empty())
                    return false;
                    
                char c = s.top();
                s.pop();

                if (c == '(' && exp[i] == ')')
                    continue;

                else if (c == '{' && exp[i] == '}')
                    continue;

                else if (c == '[' && exp[i] == ']')
                    continue;

                else
                    return false;
            }     
        }

        return(s.size() == 0);
    }
};