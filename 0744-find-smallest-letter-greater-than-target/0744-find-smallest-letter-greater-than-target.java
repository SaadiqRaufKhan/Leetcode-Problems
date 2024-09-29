class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // base condition
        // if(target > letters[letters.length - 1]) 
        //     return letters[0];
        
        int l = 0;
        int r = letters.length - 1;
        int ceil = -1;
        
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(letters[mid] <= target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                ceil = mid;
            }
        }
        return (ceil == -1) ? letters[0] : letters[ceil];
        
        
//         int s = 0;
//         int e = letters.size()-1;
//         int ceil = -1;
//         while(s <= e) {
//             int mid = s + (e - s)/2;
//             if(letters[mid] > target) {
//                 ceil = mid;
//                 e = mid - 1;
//             }
//             else {
//                 s = mid + 1;
//             }
            
//         }
        
//         return (ceil == -1) ? letters[0] : letters[ceil];
        
    }

}