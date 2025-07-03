class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            else {
                while(start < end && s.charAt(start) != s.charAt(end) ) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
                end++;
            }
            ans = Math.max(ans, end - start);

        }
        return ans;
    }
}