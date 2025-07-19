class Solution {
    public int[] countBits(int n) {
        int power = 1;
        int diff = 1;
        int[] ans = new int[n+1];

        for(int i=1; i<=n; i++) {
            if((double)i == Math.pow(2, power)){
                power++;
                diff = (int)Math.pow(2, power-1);
            }
            ans[i] = 1 + ans[i-diff];
        }
        return ans;
    }
}
/*
Basically there is pattern in the no of 1's that appear
they repeat after every power of 2 with just an increment of 1 in the no of bits
*/