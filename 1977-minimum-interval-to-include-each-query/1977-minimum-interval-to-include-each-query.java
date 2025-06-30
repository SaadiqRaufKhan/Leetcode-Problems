record Pair(int end, int size) implements Comparable<Pair> {
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.size, other.size);
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        Map<Integer, Integer> map = new HashMap<>();    // stores the answers for each query

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] queries2 = Arrays.copyOf(queries, m);
        Arrays.sort(queries2);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int j = 0;  // this will iterate over intervals
        int k = 0;  // this will iterate over queries
        while(k < m) {
            while(j < n && intervals[j][0] <= queries2[k]) {
                int e = intervals[j][1];
                int s = (intervals[j][1] - intervals[j][0]) + 1;
                pq.offer(new Pair(e, s));
                j++;
            }
            while(!pq.isEmpty() && pq.peek().end() < queries2[k]) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                map.put(queries2[k], pq.peek().size());
            }
            else {
                map.put(queries2[k], -1);
            }
            k++;
        }

        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            ans[i] = map.get(queries[i]);
        }
        return ans;
    }
}