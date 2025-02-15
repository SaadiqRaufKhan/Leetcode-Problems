class Solution {
    
    boolean isPossible(int pos, int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        int gassum = 0;
        int costsum = 0;
        while(i < n) {
            gassum += gas[pos];
            costsum += cost[pos];
            if(gassum >= costsum) {
                pos = (pos + 1) % n;
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int n = gas.length;
        // for(int i=0; i<n; i++) {
        //     if(gas[i] >= cost[i]) {
        //         if(isPossible(i, gas, cost)) {
        //             return i;
        //         }
        //     }
        // }
        // return -1;
        int totalGas = 0, currentGas = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalGas += netGain;
            currentGas += netGain;

            // If currentGas drops below 0, reset the start index
            if (currentGas < 0) {
                startIndex = i + 1;  // Try starting from the next station
                currentGas = 0;  // Reset currentGas for new start
            }
        }

        // If total gas available is less than total cost, return -1 (not possible)
        return totalGas >= 0 ? startIndex : -1;

    }
}