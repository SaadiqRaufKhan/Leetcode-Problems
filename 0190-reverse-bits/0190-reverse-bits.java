class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            res = res << 1;     // left shift res to make space at the end
            res = res | (n & 1);    // take OR with last digit of n
            n = n >> 1;     // right shift n
        }
        return res;
    }
}