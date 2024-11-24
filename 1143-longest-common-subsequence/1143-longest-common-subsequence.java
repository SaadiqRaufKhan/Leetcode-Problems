class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        
        // initialize dp
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>(l1+1);
        for(int i=0; i<=l1; i++) {
            ArrayList<Integer> temp = new ArrayList<>(l2+1);
            for(int j=0; j<=l2; j++) {
                temp.add(0);
            }
            dp.add(temp);
        }
        
        // fill dp
        for(int i=1; i<=l1; i++) {
            for(int j=1; j<=l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    int res = dp.get(i-1).get(j-1) + 1;
                    dp.get(i).set(j, res);
                }
                else {
                    int res = Math.max(dp.get(i-1).get(j), dp.get(i).get(j-1));
                    dp.get(i).set(j, res);
                }
            }
        }
        
        return dp.get(l1).get(l2);
        
        
        
    }
}