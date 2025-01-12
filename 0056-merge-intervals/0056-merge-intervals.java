class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));

        List<int[]> ans = new ArrayList<>();

        // pick each element and check if they can be merged in the last interval of ans
        for(int i=0; i<n; i++) {
            int size = ans.size();
            // can't merge current interval into the last interval of ans
            if(size == 0 || ans.get(size-1)[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            }
            // merge current interval ans update the 'end' of interval
            else {
                ans.get(size-1)[1] = Math.max(intervals[i][1], ans.get(size-1)[1]);
            }
        }
        return ans.toArray(new int[0][]);
    }
}

    // public int[][] merge(int[][] intervals) {
    //     int n = intervals.length;
    //     Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));

    //     List<int[]> ans = new ArrayList<>();
    //     int i = 0;
    //     while(i < n) {
    //         int left = intervals[i][0];
    //         int right = intervals[i][1];
    //         while(i < n-1 && right >= intervals[i+1][0]) {
    //             right = Math.max(right, intervals[i+1][1]);
    //             i++;
    //         }
    //         ans.add(new int[]{left, right});
    //         i++;
    //     }
    //     int[][] result = ans.toArray(new int[0][]);
    //     return result;
    // }