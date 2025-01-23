class Solution {
    void merge(int[] nums, int s, int m, int e) {
        int i = s;
        int j = m+1;
        int k = 0; 
        int[] merged = new int[e-s+1];
 
        while(i <= m && j <= e) {
            if(nums[i] <= nums[j]) {
                merged[k++] = nums[i++];
            }
            else {
                merged[k++] = nums[j++];
            }
        }
        while(i <= m) {
            merged[k++] = nums[i++];
        }
        while(j <= e) {
            merged[k++] = nums[j++];
        }
        
        for(int l=s; l<=e; l++) {
            nums[l] = merged[l-s];
        }
    }
    int countpairs(int[] nums, int s, int m, int e) {
        int j = m+1;
        int cnt = 0;
        for (int i = s; i <= m; i++) {
            while (j <= e && nums[i] > (long)(2 * (long)nums[j]))  {
                j++;
            }
            cnt += (j - m - 1);
        }
        return cnt;

    }

    int mergeSort(int[] nums, int s, int e) {
        // System.out.println("mergesort for s = " + s + ", e = " + e);
        int ans = 0;
        if(s < e) {
            int m = s + (e - s)/2;
            int c1 = mergeSort(nums, s, m);
            int c2 = mergeSort(nums, m+1, e);
            int c3 = countpairs(nums, s, m, e);
            merge(nums, s, m, e);
            ans += (c1 + c2 + c3);
        }
        // System.out.println("returning with total inv = " + ans);
        return ans;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}