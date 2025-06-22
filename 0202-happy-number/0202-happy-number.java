class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        s.add(n);
        while(n != 1) {
            // System.out.println(n);
            int nn = 0;
            while(n > 0) {
                int d = n % 10;
                nn += Math.pow(d, 2);
                n /= 10;
            }
            if(s.contains(nn)) return false;
            s.add(nn);
            n = nn;
        }
        return true;
    }
}