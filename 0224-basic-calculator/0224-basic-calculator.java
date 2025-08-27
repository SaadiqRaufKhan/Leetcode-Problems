class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;     // final result to be returned
        int number = 0;     // current number
        int sign = 1;       
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }
            else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            }
            else if(c == ')'){
                result += sign * number;  
                number = 0;
                result *= stack.poll();     // stack.poll() is the sign before the parenthesis
                result += stack.poll();     // stack.poll() now is the result calculated before the parenthesis
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
}