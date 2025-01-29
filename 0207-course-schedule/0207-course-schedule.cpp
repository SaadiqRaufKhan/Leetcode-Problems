// The problem is same as finding cycle in a directed graph

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // we can treat each row of prerequisites as a dir-edge
        vector<vector<int>> adjList(numCourses, vector<int>());
        for(auto edge: prerequisites) {
            adjList[edge[0]].push_back(edge[1]);
        }

        vector<bool> visited(numCourses, false);
        vector<int> indegree(numCourses, 0);

        for(auto edge: prerequisites) {
            indegree[edge[1]]++;
        }

        queue<int> q; // to store zero indegree nodes
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }

        vector<int> toposort;
        while(!q.empty()) {
            int front = q.front();
            q.pop();
            toposort.push_back(front);

            for(auto adjVertex: adjList[front]) {
                indegree[adjVertex]--;
                if(indegree[adjVertex] == 0) {
                    q.push(adjVertex);
                }
            }

        }
        return (toposort.size() == numCourses);
    }
};