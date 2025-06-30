class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int m = people.length;
        Arrays.sort(flowers, (a,b) -> Integer.compare(a[0], b[0]));
        int[] people2 = Arrays.copyOf(people, m);
        Arrays.sort(people2);
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int j = 0;
        for(int i=0; i<m; i++) {
            while(j < n && flowers[j][0] <= people2[i]) {
                pq.offer(flowers[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < people2[i]) {
                pq.poll();
            }
            map.put(people2[i], pq.size());
        }

        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            ans[i] = map.get(people[i]);
        }

        return ans;
    }
}