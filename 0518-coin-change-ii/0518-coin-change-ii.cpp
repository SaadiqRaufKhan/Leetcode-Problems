// class Solution {
// public:
//     int change(int amount, vector<int>& coins) {
//         int n = coins.size();
//         // 2D array: n-rows for each coin & amount+1 cols for each amount from 0 to amount
//         vector<vector<long long>> dp(n, vector<long long>(amount+1, 0));

//         // 0th col: one way to make 0 amount
//         for(int i=0; i<n; i++) {
//             dp[i][0] = 1;
//         }

//         // initialize the first row
//         for(int a=0; a<=amount; a++) {
//             // check how many amounts can be made using 0th coin
//             // if the amount is divisible by coin value this means we can form that amount with the given coin
//             if(a % coins[0] == 0) {
//                 dp[0][a] = 1;
//             }
//             // otherwise we already have zero for the else case
//         }

//         // fill the dp array
//         for(int i=1; i<n; i++) {
//             for(int a=1; a<=amount; a++) {
//                 // not taking the curr coin
//                 long long notTaken = dp[i-1][a];

//                 // take the ith coin only if the coin value is less than the curr amount 'a'
//                 long long taken = 0;
//                 if(coins[i] <= a) {
//                     taken = dp[i][a-coins[i]];
//                 }

//                 // store the final sum
//                 dp[i][a] = taken + notTaken;
//             }
//         }

//         return dp[n-1][amount];

//     }
// };
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> dp(amount + 1, 0);
        dp[0] = 1;

        for (int coin : coins) {
            if (coin <= 0) continue; // prevent infinite loops if 0 appears
            for (int a = coin; a <= amount; a++) {
                if (dp[a - coin] > 0 && dp[a] <= INT_MAX - dp[a - coin]) {
                    dp[a] += dp[a - coin];
                }
            }
        }

        return dp[amount];
    }
};
