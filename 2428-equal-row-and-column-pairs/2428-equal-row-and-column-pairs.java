// class Solution {
//     public int equalPairs(int[][] grid) {
//         int n = grid.length;

//         Map<String, Integer> map = new HashMap<>();

//         for(int i=0; i<n; i++) {
//             String row = "";
//             for(int j=0; j<n; j++) {
//                 row += String.valueOf(grid[i][j]) + "_";
//             }
//             map.put(row, map.getOrDefault(row, 0) + 1);
//         }

//         int ans = 0;
//         for(int i=0; i<n; i++) {
//             String col = "";
//             for(int j=0; j<n; j++) {
//                 col += String.valueOf(grid[j][i]) + "_";
//             }
            
//             if(map.containsKey(col) && map.get(col) > 0) {
//                 ans += map.get(col);
//             }
//         }

//         return ans;
//     }
// }

// class Solution {
//     public int equalPairs(int[][] grid) {
//         int n = grid.length;
//         Map<String, Integer> map = new HashMap<>();
//         StringBuilder sb;

//         // store rows
//         for (int i = 0; i < n; i++) {
//             sb = new StringBuilder(n * 4); // small heuristic for capacity
//             for (int j = 0; j < n; j++) {
//                 sb.append(grid[i][j]).append(','); // delimiter to avoid collisions
//             }
//             String key = sb.toString();
//             map.put(key, map.getOrDefault(key, 0) + 1);
//         }

//         int ans = 0;
//         // check columns
//         for (int c = 0; c < n; c++) {
//             sb = new StringBuilder(n * 4);
//             for (int r = 0; r < n; r++) {
//                 sb.append(grid[r][c]).append(',');
//             }
//             ans += map.getOrDefault(sb.toString(), 0);
//         }
//         return ans;
//     }
// }

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();

        // store rows
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) row.add(grid[i][j]);
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int ans = 0;
        // check columns
        for (int c = 0; c < n; c++) {
            List<Integer> col = new ArrayList<>(n);
            for (int r = 0; r < n; r++) col.add(grid[r][c]);
            ans += map.getOrDefault(col, 0);
        }
        return ans;
    }
}
