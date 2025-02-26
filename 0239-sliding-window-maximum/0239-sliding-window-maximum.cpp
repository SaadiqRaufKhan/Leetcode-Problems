class Solution {
public:
    // int getMax(vector<int>& nums, int s, int e) {
    //     int currmax = INT_MIN;
    //     for(int i=s; i<=e; i++) {
    //         currmax = max(currmax, nums[i]);
    //     }
    //     return currmax;
    // }
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        // vector<int> ans;
        // queue<int> q;
        // int currmax = INT_MIN;
        // for(int i=0; i<k; i++) {
        //     currmax = max(currmax, nums[i]);
        //     q.push(nums[i]);
        // }
        // ans.push_back(currmax);

        // for(int i=k; i<nums.size(); i++) {
        //     int front = q.front();
        //     q.pop();
        //     q.push(nums[i]);
        //     if(front == currmax) {
        //         currmax = getMax(nums, i-k+1, i);
        //     }
        //     else {
        //         currmax = max(currmax, nums[i]);
        //     }
        //     ans.push_back(currmax);
        // }
        // return ans;

        
        vector<int> ans;
        deque<int> q;

        for(int i=0; i<k; i++) {
            // remove smaller elements from queue
            while(!q.empty() && q.back() < nums[i]) {
                q.pop_back();
            }
            q.push_back(nums[i]);
        }
        ans.push_back(q.front());

        for(int i=k; i<nums.size(); i++) {
            // first remove the smaller elements from the queue
            while(!q.empty() && q.back() < nums[i]) {
                q.pop_back();
            }
            q.push_back(nums[i]);
            if(q.front() == nums[i-k]) {
                q.pop_front();
            }
            ans.push_back(q.front());
        }
        return ans;
    }
};















/*
vector<int> ans;
deque<int> q;
int i = 0, j = 0;
while(j < nums.size()) {
    // push to q the jth element
    while(!q.empty() && q.back() < nums[j]) {
        q.pop_back();
    }
    q.push_back(nums[j]);

    if(j-i+1 == k) {
        ans.push_back(q.front());
        if(q.front() == nums[i]) {
            q.pop_front();
        }
        i++;
    }
    j++;
}
return ans;

*/