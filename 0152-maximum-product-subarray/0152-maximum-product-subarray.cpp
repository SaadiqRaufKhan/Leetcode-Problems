class Solution {
public:
    // 2 loop approach 
    /*int maxProduct(vector<int>& nums) {
        
        int maxLeft = INT_MIN;
        int maxRight = INT_MIN;
        
        // curr product
        int currProd = 1;
        
        // flag to check the presence of 0
        bool zeroPresent =  false;
        
        for(int i=0; i<nums.size()-1; i++) {
            // if curr elem is 0, reset the product, mark the zero flag and go to next iteration
            if(nums[i] == 0) {
                zeroPresent = true;
                currProd = 1;
                continue;
            }
            // else just update curr prod and lmax
            currProd *= nums[i];
            maxLeft = max(maxLeft,currProd);
        }
        
        currProd = 1;
        
        for(int j=nums.size()-1; j>=0; j--) {
            // if curr elem is 0, reset the product, mark the zero flag and go to next iteration
            if(nums[j] == 0) {
                zeroPresent = true;
                currProd = 1;
                continue;
            }
            // else just update curr prod and rmax
            currProd *= nums[j];
            maxRight = max(maxRight,currProd);
        }
        
        if(zeroPresent) {
            return max(max(maxLeft,maxRight),0);
        }

        return max(maxLeft,maxRight);
        
    }*/

    // 1 loop approach
    int maxProduct(vector<int>& nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.size(); i++) {
            // first store maxProd's final value in a temp variable so that it doesn't get affected when we update minProd
            int temp = max({nums[i], nums[i] * maxProd, nums[i] * minProd});
            minProd = min({nums[i], nums[i] * maxProd, nums[i] * minProd});
            maxProd = temp;

            result = max(result, maxProd);

        }
        return result;
    }

};