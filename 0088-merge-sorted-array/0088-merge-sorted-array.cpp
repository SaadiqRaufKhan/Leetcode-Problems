class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        // shift the elements of nums1 to the right by n positions
        for(int i=m+n-1; i>=n; i--) {
            nums1[i] = nums1[i-n];
        }

        // do the basic merging using nums1 as the merged array
        int pos = 0;    // start for merged 
        int i = n;      // start for nums1
        int j = 0;      // start for nums2

        while(i != m+n && j != n) {
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

        while(j != n) {
            nums1[pos] = nums2[j];
            pos++; j++;
        }
    }
};