class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        boolean flag = true;
        while(i < word1.length() && j < word2.length()) {
            if(flag) {
                res.append(word1.charAt(i++));
                flag = !flag;
            }
            else {
                res.append(word2.charAt(j++));
                flag = !flag;
            }
        }

        if(i < word1.length()) {
            res.append(word1.substring(i));
        }
        if(j < word2.length()) {
            res.append(word2.substring(j));
        }

        return res.toString();
        
    }
}