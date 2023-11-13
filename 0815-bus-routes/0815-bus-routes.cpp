class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        if(source == target) return 0;
        
        unordered_map<int, vector<int>> adjList;
        
        // there are "routes.size()" no of routes 
        for(int route=0; route<routes.size(); route++) {
            for(auto stop: routes[route]) {
                adjList[stop].push_back(route);
            }
        }
        
        queue<int> q;
        unordered_set<int> vis;
        
        // push all the routes of source in the q
        for(auto route: adjList[source]) {
            q.push(route);
            vis.insert(route);
        }
        
        // apply BFS
        int busCount = 1;
        while(!q.empty()) {
            int size = q.size();
            while(size--) {
                int currRoute = q.front(); q.pop();
                for(auto stop: routes[currRoute]) {
                    if(stop == target) {
                        return busCount;
                    }
                    for(auto nextRoute: adjList[stop]) {
                        if(!vis.count(nextRoute)) {
                            vis.insert(nextRoute);
                            q.push(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
};