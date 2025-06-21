class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int i = n-1;
        while(i >= 0 && carry == 1) {
            int d = digits[i];
            if(d+carry == 10) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                carry = 0;
            }
            i--;
        }

        if(carry == 1) {
            int[] ans = new int[n+1];
            ans[0] = 1;
            for(int j=0; j<n; j++) {
                ans[j+1] = digits[j];
            }
            return ans;
        }
        return digits;
    }

}