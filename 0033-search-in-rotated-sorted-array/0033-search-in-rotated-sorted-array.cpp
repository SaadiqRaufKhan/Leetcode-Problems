class Solution {
public:
    /*
    int BS(vector<int> arr, int target, int s, int e) {        
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
    // find the idx of rotation by finding the smallest element
    int findSmallest(vector<int> arr, int s, int e) {
        int n = arr.size();
        
        while(s <= e) {
            int mid = s + (e-s)/2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n; // for handling mid = 0 
            
            if(arr[mid] < arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }
            // check if the [0 to mid] half is sorted or not
            else if(arr[0] <= arr[mid]) {
                // smallest is in other half (right of mid)
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return 0;
    }
    int search(vector<int>& arr, int target) {
        // this will give us the two sorted halves
        int idx = findSmallest(arr, 0, arr.size()-1);
        
        // apply BS on both the sorted halves
        int x = BS(arr, target, 0, idx-1);
        int y = BS(arr, target, idx, arr.size()-1);
        
        if(x == -1 && y == -1) return -1;
        
        return (x == -1) ? y : x;
    }
    */
    
    int search(vector<int>& arr, int target) {
        int s = 0;
        int e = arr.size() - 1;
        while(s <= e) {
            int mid = (s + e)/2;
            // we found the element at mid
            if(arr[mid] == target) {
                return mid;
            }
            // Case 1: mid on line 1
            else if(arr[s] <= arr[mid]) {
                // Case 1a: target on the left of mid
                if(target >= arr[s] && target < arr[mid]) {
                    e = mid - 1;
                }
                // Case 1b: target on the right of mid
                else {
                    s = mid + 1;
                }
            }
            // Case 2: mid on line 2
            else {
                if(target>arr[mid] and target<=arr[e]){
                    s = mid + 1;
                }
                else{
                    e = mid - 1;
                }
            }
        }
        // if we couldn't find the element in the while loop this means it is not present in the array
        // return -1 in this case
        return -1;
    }
    
};



