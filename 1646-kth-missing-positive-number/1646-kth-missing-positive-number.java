class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int ans = 1;

        // while(i < arr.length && ans == arr[i]) {
        //     ans++;
        //     i++;
        // }
        // if(k == 1) return ans;


        while(i < arr.length && k > 1) {
            if(ans == arr[i]) {
                i++;
                ans++;
            }
            else {
                while(k > 1 && ans != arr[i]) {
                    ans++;
                    k--;
                }
            }
        }
        // we have used all k's
        if(k == 1) {
            // condition to check if ans matches with arr[i]
            // increase ans while it is same as arr[i]
            while(i < arr.length && ans == arr[i]) {
                ans++;
                i++;
            }
            return ans;
        }

        // array was exhausted but k was still not 1
        while(k > 1) {
            ans++;
            k--;
        }
        return ans;
    }
}