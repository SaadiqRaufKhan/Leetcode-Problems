class Solution {
public:
    string simplifyPath(string path) {
        stack<string> s;
        int i = 0;
        // push normal files to stack, ignore ".", and pop files for ".."
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

        // build the final path
        string ans = "";
        while(!s.empty()) {
            string top = s.top();
            s.pop();
            ans = '/' + top + ans;
        }

        return (ans.length() == 0) ? "/" : ans;
    }
};