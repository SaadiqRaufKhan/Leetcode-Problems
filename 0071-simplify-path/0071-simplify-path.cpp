class Solution {
public:
    string simplifyPath(string path) {
        stack<string> s;
        int i = 0;
        while(i<path.length()) {
            if(path[i] == '/') {
                i++;
                string filename = "";
                while(i < path.length() && path[i] != '/') {
                    filename += path[i++];
                }
                if(filename.length() > 0) {
                    if(filename == "..") {
                        if(!s.empty()) s.pop();    // pop previous file
                    }
                    else if(filename == ".") {
                        continue;                   // ignore this
                    }
                    else {
                        s.push(filename);
                    }
                }
            }
        }

        string ans = "";
        while(!s.empty()) {
            string top = s.top();
            s.pop();
            // if(top == "..") {
            //     if(!s.empty()) s.pop();
            // }
            // else if(top == ".") {
            //     continue;
            // }
            // else {
                ans = '/' + top + ans;
            // }
        }

        return (ans.length() == 0) ? "/" : ans;
    }
};