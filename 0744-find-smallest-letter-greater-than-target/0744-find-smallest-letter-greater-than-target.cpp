class Solution {
public:
    // similar to finding ceiling
    char nextGreatestLetter(vector<char>& letters, char target) {
        int s = 0;
        int e = letters.size()-1;
        int ceil = -1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(letters[mid]  > target ) {
                ceil = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
            
        }
        
        return (ceil == -1) ? letters[0] : letters[ceil];
    }
};