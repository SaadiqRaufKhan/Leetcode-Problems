class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for(char c: word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        for(char c: word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        if(freq1.size() != freq2.size()) return false;

        // freq count
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int value: freq1.values()) {
            freqCount.put(value, freqCount.getOrDefault(value, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : freq2.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(!freq1.containsKey(entry.getKey()) || !freqCount.containsKey(val) || freqCount.get(val) <= 0) {
                return false;
            }
            
            freqCount.put(val, freqCount.get(val) - 1);
        }
        return true;
    }
}