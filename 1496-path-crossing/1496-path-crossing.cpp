typedef pair<int,int> pairs;
class Solution {
public:
    bool isPathCrossing(string path) {
        pair<int,int> pos = {0,0};
        set<pairs> s;
        s.insert(pos);
        for(auto c: path) {
            if(c == 'N') {
                pos.second++;
            }
            else if(c == 'S') {
                pos.second--;
            }
            else if(c == 'E') {
                pos.first++;
            }
            else if(c == 'W') {
                pos.first--;
            }
            cout << "x = " << pos.first << " y = " << pos.second << endl; 
            
            if(s.find(pos) != s.end()) {
                return true;
            }
            else {
                s.insert(pos);
            }
        }
        return false;
    }
};