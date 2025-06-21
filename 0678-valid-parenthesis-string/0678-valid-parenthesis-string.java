class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();   // indices of '('
        Deque<Integer> star = new ArrayDeque<>();   // indices of '*'

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') left.push(i);
            else if(s.charAt(i) == '*') star.push(i);
            else {
                if(!left.isEmpty()) {
                    left.pop();
                }
                else if(!star.isEmpty()) {
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        // some open paranthesis are still remaining
        while(!left.isEmpty() && !star.isEmpty() && left.peek() < star.peek()) {
            left.pop();
            star.pop();
        }

        return left.isEmpty();
    }
}