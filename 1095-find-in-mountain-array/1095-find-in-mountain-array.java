/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */


// SELF NOTE: since this is a mountain array, we'll find the peak element's index
// then we'll apply order-agnostic Binary Search on each side of the peak element
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        System.out.println("peak = " + peak);
        
        int res1 = binarySearch(target, mountainArr, 0, peak);
        System.out.println("res1 = " + res1);
        if(res1 != -1) {
            return res1;
        }
        
        return binarySearch(target, mountainArr, peak, mountainArr.length()-1);
    }
    
    public int findPeak(MountainArray arr) {
        int s = 0;
        int e = arr.length() - 1;
        
        while(s < e) {
            int mid = s + (e - s)/2;
            if(arr.get(mid) > arr.get(mid+1)) {
                e = mid;
            }
            else {
                s = mid + 1;
            }
        }
        return s;
    }
    
    int binarySearch(int target, MountainArray arr, int s, int e) {
        boolean isAsc = (arr.get(s) < arr.get(e));
        while(s <= e) {
            System.out.println("s = " + s);
            System.out.println("e = " + e);
            int mid = s + (e - s)/2;
            System.out.println("mid = " + mid);
            if(arr.get(mid) == target) {
                return mid;
            }
            if(isAsc) {
                if(arr.get(mid) < target) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
            else {
                if(arr.get(mid) > target) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
            
        }
        return -1;
    }
}