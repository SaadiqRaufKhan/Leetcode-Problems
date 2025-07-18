class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue<pair<int,int>> pq;

        for(int i=0; i<arr.size(); i++) {
            pair<int, int> p = {abs(arr[i] - x), arr[i]};
            if(pq.size() < k) {
                pq.push(p);
            }
            else {
                pair<int,int> top = pq.top();
                if(p < top) {
                    pq.pop();
                    pq.push(p);
                }
            }
        }

        vector<int> ans;
        while(pq.size() > 0) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};