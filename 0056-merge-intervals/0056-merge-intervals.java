class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (row1, row2) -> Integer.compare(row1[0], row2[0]));
        for(int i=0; i<n; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while(i < n) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < n-1 && right >= intervals[i+1][0]) {
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            ans.add(new int[]{left, right});
            i++;
        }
        int[][] result = ans.toArray(new int[0][]);
        return result;
    }
}