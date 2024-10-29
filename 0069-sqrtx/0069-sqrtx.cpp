class Solution {
public:
    int mySqrt(int x) {
        
        if (x == 0 || x == 1) {
            return x;
        }
        int s = 1;
        int e = (x/2);
        int ans;
        while(s <= e) {
            long long int mid = (s + e)/2;  //  (e-s)/2 + s
            long long int sq = mid*mid;
            if(sq == x) {
                ans = mid;
                break;
            }
            else if(mid*mid < x) {
                s = mid + 1;
                ans = mid;
            }
            else {
                e = mid - 1;
            }
        }
        return ans;
    }
};