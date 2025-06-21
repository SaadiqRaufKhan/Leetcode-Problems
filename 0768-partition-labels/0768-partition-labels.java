class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i=0; i<n; i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int i = 0;
        while(i < n) {
            int currend = lastIndex.get(s.charAt(i));
            int j = currend - 1;
            while(j > i) {
                if(lastIndex.get(s.charAt(j)) > currend) {
                    currend = lastIndex.get(s.charAt(j));
                    j = currend - 1;
                }
                else {
                    j--;
                }
            }
            ans.add(currend - i + 1);
            i = currend + 1;
        }
        return ans;
    }
}