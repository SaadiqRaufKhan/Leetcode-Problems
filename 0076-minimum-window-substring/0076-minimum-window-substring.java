
// class Solution {
//     public String minWindow(String s, String t) {
//         if(t.length() > s.length()) return "";

//         Map<Character, Integer> map = new HashMap<>();
//         for(char c: t.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

        

//         List<Integer> startPoints = new ArrayList<>();
//         for(int i=0; i<s.length(); i++) {
//             if(map.containsKey(s.charAt(i))) {
//                 startPoints.add(i);
//             }
//         }
        

//         int minLength = Integer.MAX_VALUE;
//         int sp = 0;
//         int start = startPoints.get(sp++);
//         int end = start;
        
//         Map<Character, Integer> mapCopy = new HashMap<>();
//         String ans = "";
//         while(sp < startPoints.size()) {
//             while(end < s.length() && !mapCopy.equals(map)) {
//                 char c = s.charAt(end);
//                 if(map.containsKey(c)) {
//                     if(!mapCopy.containsKey(c) || mapCopy.get(c) < map.get(c)) {
//                         mapCopy.put(c, mapCopy.getOrDefault(c, 0) + 1);
//                     }
//                 }
//                 end++;
//             }
//             // System.out.println(start + " " + end);
//             if(mapCopy.equals(map) && (end - start) < minLength) {
//                 ans = s.substring(start, end);
//                 minLength = end - start;
//                 mapCopy.put(s.charAt(start), mapCopy.get(s.charAt(start)) - 1);
//             }
//             start = startPoints.get(sp++);
//         }
//         return ans;
//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // Update result
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).intValue() == need.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
