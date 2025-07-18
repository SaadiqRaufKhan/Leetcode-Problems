record Pair(int diff, int element) implements Comparable<Pair> {
    @Override
    public int compareTo(Pair other) {
        if (this.diff == other.diff) {
            return Integer.compare(this.element, other.element);
        }
        return Integer.compare(this.diff, other.diff);
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            Pair p = new Pair(Math.abs(arr[i] - x), arr[i]);
            if(pq.size() < k) {
                pq.offer(p);
            }
            else {
                Pair top = pq.peek();
                if(p.compareTo(top) < 0) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }

        while(!pq.isEmpty()) {
            ans.add((pq.poll()).element());
        }

        Collections.sort(ans);
        return ans;
    }
}