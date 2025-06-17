class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        
        Arrays.sort(hand);

        Map<Integer, Integer> freq = new HashMap<>();
        for(int h: hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }
        
        int groups = 0;
        for(int i=0; i<n; i++) {
            if(freq.get(hand[i]) > 0) {
                freq.put(hand[i], freq.get(hand[i])-1);
                int size = 1;
                int next = hand[i] + 1;
                while(freq.containsKey(next) && freq.get(next) > 0 && size != groupSize) {
                    freq.put(next, freq.get(next) - 1);
                    size++;
                    next++;
                }

                if(size == groupSize) groups++;
            }
        }
        return groups == (n / groupSize);
    }
}