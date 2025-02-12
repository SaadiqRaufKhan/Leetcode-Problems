class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());

        // this is the maximum possible value for h-index because it bound by the no 
        // the of research papers and the researcher has citations.size() research papers
        int curr_h_idx = citations.size();
        for(int i=0; i<citations.size(); i++) {
            if(citations[i] >= curr_h_idx) {
                return curr_h_idx;
            }
            // we need to decrease it by one in each iteration because we are 
            // losing one research paper that doesn't have enough citations
            curr_h_idx--;
        }
        return 0;
    }
};