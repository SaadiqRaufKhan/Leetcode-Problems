// YT soln: https://www.youtube.com/watch?v=6fNdpbSqKB0
class Solution {
public:
    bool checkIfGood(int currMask, int prevMask, vector<vector<char>>& seats, int curr, int n){
        int prevBit = 0;
        for(int i=0;i<n;i++){
            bool set = ((1<<i)&currMask);
            if(!set){
                prevBit = 0;
                continue;
            }
            if(seats[curr][i]=='#' || prevBit){
                return false;
            }
            if(i>0 && (((1<<(i-1))&prevMask) || ((1<<(i+1))&prevMask))){
                return false;
            }
            else if((1<<(i+1))&prevMask){
                return false;
            }
            prevBit = 1;
        }
        return true;
    }
    int countBits(int n) {
        int cnt = 0;
        for(int i=0;i<10;i++) {
            if((n>>i)&1) cnt++;
        }
        return cnt;
    }
    int dp[10][257];
    int recurse(int currRow, int prevMask, vector<vector<char>>& seats, int n){
        if(currRow >= seats.size()){
            return 0;
        }
        if(dp[currRow][prevMask]!=-1){
            return dp[currRow][prevMask];
        }
        int ans = 0;
        for(int i=0;i<(1<<n);i++){
            int currMask = i;
            if(checkIfGood(currMask, prevMask, seats, currRow, n)){
                ans = max(ans, countBits(currMask) + recurse(currRow+1, currMask, seats, n));
            }
        }

        return dp[currRow][prevMask] = ans;
    }
    int maxStudents(vector<vector<char>>& seats) {

        memset(dp,-1,sizeof(dp));

        int n = seats[0].size();
        int ans = recurse(0,0,seats,n);

        return ans;
    }
};

/*
// self solution -> gives TLE ;_; but logically correct
class Solution {
public:
    vector<vector<int>> dirs = {{-1,-1}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,1}};
    int helper(vector<vector<char>> &seats, int m, int n, long long mask, unordered_map<long long , int> &dp) {
        if(dp.find(mask) != dp.end()) return dp[mask];

        int ans = 0;
        for(int seat=0; seat<m*n; seat++) {
            if(!(mask & (1ll << seat))) {    // 0 at ith position i.e. seat is available
                int x = seat / n;
                int y = seat - (x*n);
                // check all the cheating directions
                bool can_place = true;
                for(vector<int> dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && seats[nx][ny] == 'o') {
                        can_place = false;
                        break;
                    }
                }
                if(can_place) {
                    seats[x][y] = 'o';  // turn seat as occupied
                    ans = max(ans, 1 + helper(seats, m, n, mask ^ (1ll << seat), dp));
                    seats[x][y] = '.';
                }
            }
        }
        return dp[mask] = ans;
    }

    int maxStudents(vector<vector<char>>& seats) {
        int m = seats.size();
        int n = seats[0].size();

        long long mask = ~0ll;  // all set to 1 initially
        // make non-broken chairs as 0
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(seats[i][j] == '.') {
                    int bit_pos = (i*n) + j;
                    mask = mask ^ (1ll << bit_pos);
                }
            }
        }
        unordered_map<long long, int> dp;
        return helper(seats, m, n, mask, dp);
    }
};
*/