class Solution {
    /* lul approach
    for(int j=0; j<n; j++) {
            nums1[m+j] = nums2[j];
        }
        Arrays.sort(nums1);
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // shift the elements of nums1 by n places to the right 
        // we can do so because the total size of the nums1 array is m+n
        // so each element of nums1 can be easily shifted to right by n places

        for(int i=m-1; i>=0; i--) {   // go right to left
            nums1[i+n] = nums1[i];
        }
        for(int e: nums1) {
            System.out.println(e + ", ");
        }

        // now aplly regular merging logic
        int i = n;
        int j = 0;
        int pos = 0;

        while(i < m + n && j < n) {
            if(nums1[i] < nums2[j]) {
                nums1[pos] = nums1[i];
                i++; 
            } 
            else {
                nums1[pos] = nums2[j];
                j++;
            }
            pos++;
        }
        
        while(j < n) {
            nums1[pos] = nums2[j];
            j++; pos++;
        }


    }
}