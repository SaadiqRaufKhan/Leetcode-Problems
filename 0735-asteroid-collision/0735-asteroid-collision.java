class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> s = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            if(s.isEmpty()) {
                s.push(asteroids[i]);
            }
            else {
                boolean isOpposite = (asteroids[i] < 0 && s.peek() > 0);
                if(isOpposite) {
                    boolean isDead = false;
                    while(!s.isEmpty() && s.peek() > 0) {
                        if(s.peek() == Math.abs(asteroids[i])) {
                            isDead = true;
                            s.pop();
                            break;
                        }
                        else if(s.peek() < Math.abs(asteroids[i])) {
                            s.pop();
                        }
                        else {
                            isDead = true;
                            break;
                        }
                    }
                    if(!isDead) {
                        s.push(asteroids[i]);
                    }
                }
                else {
                    s.push(asteroids[i]);
                }
            }
        }

        int num = s.size();
        if(num == 0) {
            return new int[] {};
        }
        int[] ans = new int[num];
        for(int i=num-1; i>=0; i--) {
            ans[i] = s.peek();
            s.pop();
        } 
        return ans;
    }
}