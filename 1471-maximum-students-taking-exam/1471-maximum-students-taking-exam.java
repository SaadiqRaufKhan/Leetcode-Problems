import java.util.*;

class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        int[] validRows = new int[m];

        // Step 1: Convert each row to a bitmask of available seats
        for (int i = 0; i < m; i++) {
            int rowMask = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    rowMask |= (1 << j);
                }
            }
            validRows[i] = rowMask;
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0); // Base case: no students placed yet

        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();

            // Try every possible seating configuration for the current row
            for (int curr = 0; curr < (1 << n); curr++) {
                // 1. Must only use non-broken seats
                if ((curr & validRows[i]) != curr) continue;

                // 2. No adjacent students in same row
                if ((curr & (curr >> 1)) != 0) continue;

                for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                    int prev = entry.getKey();
                    int val = entry.getValue();

                    // 3. No cheating with diagonals from previous row
                    if ((curr & (prev >> 1)) != 0) continue;
                    if ((curr & (prev << 1)) != 0) continue;

                    int count = Integer.bitCount(curr);
                    newDp.put(curr, Math.max(newDp.getOrDefault(curr, 0), val + count));
                }
            }

            dp = newDp;
        }

        int ans = 0;
        for (int val : dp.values()) {
            ans = Math.max(ans, val);
        }

        return ans;
    }
}
