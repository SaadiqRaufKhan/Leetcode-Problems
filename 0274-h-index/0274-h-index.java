class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int curr_h_idx = n;
        for(int i=0; i<n; i++) {
            if(citations[i] >= curr_h_idx) {
                return curr_h_idx;
            }
            curr_h_idx--;
        }
        return curr_h_idx;
        
    }
}