class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentGas = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGain = gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += netGain;

            // If currentGas drops below 0, reset the start index
            if (currentGas < 0) {
                startIndex = i + 1;  // Try starting from the next station
                currentGas = 0;  // Reset currentGas for new start
            }
        }

        // If total gas available is less than total cost, return -1 (not possible)
        return (totalGas - totalCost) >= 0 ? startIndex : -1;

    }
}