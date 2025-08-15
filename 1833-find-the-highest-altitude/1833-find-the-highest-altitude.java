class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int currAlt = 0;
        for(int g: gain) {
            currAlt += g;
            ans = Math.max(ans, currAlt);
        }
        return ans;
        
    }
}