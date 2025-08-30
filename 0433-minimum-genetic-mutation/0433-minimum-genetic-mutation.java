class Solution {
    int diff(String s1, String s2) {
        int res = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) res++;
        }
        return res;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        int ans = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String gene = q.poll();
                visited.add(gene);
                for(String mutation: bank) {
                    if(!visited.contains(mutation) && (diff(mutation, gene) == 1)) {
                        if(mutation.equals(endGene)) return ans;
                        q.offer(mutation);
                    }
                }
                size--;
            }
            ans++;
        }
        return -1;
    }
}