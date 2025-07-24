class Solution {
    public int reverse(int x) {
        int newx = 0;
        while(x != 0) {
            if(newx > Integer.MAX_VALUE/10 || newx < Integer.MIN_VALUE/10) {
                return 0; // we will cross int limit 
            }
            newx *= 10;
            newx += x % 10;
            x /= 10;
        }
        return newx;
    }
}

/**
class Solution {
    public int reverse(int x) {
        boolean flag = (x < 0) ? true : false;

        if(flag) x *= -1;

        List<Integer> l = new ArrayList<>();

        while(x > 0) {
            int digit = x % 10;
            x /= 10;
            l.add(digit);
        }

        long ans = 0;   // long to store large answers
        int power = l.size() - 1;
        for(int i=0; i<l.size(); i++) {
            ans += (l.get(i) * Math.pow(10, power));
            power--;
        }
        if (ans > Integer.MAX_VALUE) return 0;

        return (flag) ? -1*(int)ans : (int)ans;
        
    }
}
 */