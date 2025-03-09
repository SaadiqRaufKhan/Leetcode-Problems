class Solution {
public:
    int numberOfAlternatingGroups(vector<int>& colors, int k) {
        vector<int> arr(colors);
        for(int i=0; i<k-1; i++) {
            arr.push_back(arr[i]);
        }

        int left = 0;
        int right = 1;
        int ans = 0;

        while(right < arr.size()) {
            if(arr[right] == arr[right-1]) {
                left = right;
                right++;
                continue;
            }

            right++;

            if(right - left < k) continue;

            left++;
            ans++;
        }
        return ans;
    }
};