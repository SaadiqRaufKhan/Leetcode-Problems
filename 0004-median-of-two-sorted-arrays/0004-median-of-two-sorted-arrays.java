class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] a = (l1 < l2) ? nums1 : nums2;
        int[] b = (l1 < l2) ? nums2 : nums1;
        int n = l1 + l2;
        int lp_size = (n + 1) / 2;  // the size of the left part of the combined array

        // we will run BS on a (the smaller array)
        int l = 0;
        int r = a.length;

        while(l <= r) {
            int lpA_size = (l + r) / 2;
            int lpB_size = lp_size - lpA_size;

            int lpA_end = (lpA_size > 0) ? a[lpA_size - 1] : Integer.MIN_VALUE;
            int lpB_end = (lpB_size > 0) ? b[lpB_size - 1] : Integer.MIN_VALUE;
            int rpA_start = (lpA_size < a.length) ? a[lpA_size] : Integer.MAX_VALUE;
            int rpB_start = (lpB_size < b.length) ? b[lpB_size] : Integer.MAX_VALUE;

            if(lpA_end <= rpB_start && lpB_end <= rpA_start) {
                if(n % 2 == 0) {
                    int median1 = Math.max(lpA_end, lpB_end);
                    int median2 = Math.min(rpA_start, rpB_start);
                    return (double)(median1 + median2)/2.0;
                }
                else {
                    return (double)(Math.max(lpA_end, lpB_end));
                }
            }
            else if(lpA_end > rpB_start) {
                r = lpA_size - 1;   // need to take less elements from a
            }
            else {
                l = lpA_size + 1;   // need to take more elements from a
            }
        }

        return -1;

    }
}