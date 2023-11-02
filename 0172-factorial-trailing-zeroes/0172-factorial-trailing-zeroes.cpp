class Solution {
public:
    int trailingZeroes(int n) {
        int p5 = 0;
        for(int i=5; (n/i)>0; i*=5) {
            p5 += n/i;
        }
        return p5;
    }
};