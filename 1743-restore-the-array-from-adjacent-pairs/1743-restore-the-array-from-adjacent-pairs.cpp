class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        unordered_map<int,vector<int>> m;
        unordered_map<int, bool> vis;
        for(auto ap: adjacentPairs) {
            m[ap[0]].push_back(ap[1]);
            m[ap[1]].push_back(ap[0]);
        }
        
        int start;
        for(auto n: m) {
            vis[n.first] = false;
            vector<int> v = n.second;
            if(v.size() == 1) {
                start = n.first;
            }
        }
        
        
        int k = adjacentPairs.size();
        int count = 0;
        vector<int> ans;
        
        while(count <= k) {
            vis[start] = true;
            ans.push_back(start);
            vector<int> adj = m[start];
            for(auto a: adj) {
                if(!vis[a]) {
                    start = a;
                    break;
                }
            }
            count++;
        }
        
        return ans;
    }
};