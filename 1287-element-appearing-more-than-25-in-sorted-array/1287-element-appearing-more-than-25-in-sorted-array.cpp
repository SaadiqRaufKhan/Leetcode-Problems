class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int size = arr.size();
        
        if(size == 1) return arr[0];
        
        int count = 1;
        int elem = arr[0];
        for(int i=1; i<size; i++) {
            if(arr[i] == elem) {
                count++;
                if(count > size/4) {
                    return arr[i];
                }
            }
            else {
                count = 1;
                elem = arr[i];
            } 
        }
        return -1;
    }
};