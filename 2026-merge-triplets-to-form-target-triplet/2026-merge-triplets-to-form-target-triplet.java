class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        
        boolean[] valid = new boolean[n];   // to track valid triplets
        Arrays.fill(valid, true);
        
        int validTriplets = n;
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                if(triplets[i][j] > target[j]) {
                    valid[i] = false;
                    validTriplets--;
                    break;
                }
            }
        }
        if(validTriplets == 0) return false;
        
        boolean[] possible = new boolean[3];
        for(int i=0; i<n; i++) {
            if(valid[i]) {
                if(triplets[i][0] == target[0]) possible[0] = true;
                if(triplets[i][1] == target[1]) possible[1] = true;
                if(triplets[i][2] == target[2]) possible[2] = true;
            }
        }
        return possible[0] && possible[1] && possible[2];

    }
}