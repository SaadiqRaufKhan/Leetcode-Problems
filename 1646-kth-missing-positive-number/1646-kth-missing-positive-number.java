class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int ans = 1;

        while(i < arr.length && ans == arr[i]) {
            ans++;
            i++;
        }
        if(k == 1) return ans;


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
        if(k == 1) {
            while(i < arr.length && ans == arr[i]) {
                ans++;
                i++;
            }
            return ans;
        }

        while(k > 1) {
            ans++;
            k--;
        }
        return ans;
    }
}