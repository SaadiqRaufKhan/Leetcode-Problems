class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        // copy the grid in another matrix 
        vector<vector<int>> visited = grid;

        // making queue in which we will fill rotten oranges
        queue<pair<int,int>> q;
        
        // count the total no. fresh oranges at the beginning
        // and push all rotten oranges in the queue
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) {
                    q.push({i, j});
                }
                if (visited[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // freshCount = 0 means that there are no fresh oranges to be rotten -> we can simply return 0 min
        if (freshCount == 0)
            return 0;

        // q.empty() means there is no rotten orange in the grid and we still have fresh oranges in the grid
        if (q.empty())
            return -1;
        
        int minutes = -1;
        // we will cover four directions i.e. up, down, left, right
        vector<pair<int, int>> dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while (!q.empty()) {
            // pop all rotten oranges and make their neighbours as rotten
            int size = q.size();
            while (size--) {
                auto [x, y] = q.front();
                q.pop();
                for (auto [dx, dy] : dirs) {
                    int i = x + dx;
                    int j = y + dy;
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        freshCount--;
                        q.push({i, j});
                    }
                }
            }
            minutes++;
        }
        
        if (freshCount == 0)
            return minutes;
        return -1;
    }
};