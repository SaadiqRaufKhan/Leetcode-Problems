class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int n = hand.size();
        if(n % groupSize != 0) return false;
        
        unordered_map<int, int> freq;
        for(int h: hand) freq[h]++;

        sort(hand.begin(), hand.end());
        int groups = 0;
        for(int i=0; i<n; i++) {
            if(freq[hand[i]] > 0) {
                freq[hand[i]]--;
                int size = 1;
                int next = hand[i] + 1;
                while(freq.find(next) != freq.end() && freq[next] > 0 && size != groupSize) {
                    freq[next]--;
                    next++;
                    size++;
                }
                if(size = groupSize) groups++;
            }
        }

        return groups == (n/groupSize);
    }
};