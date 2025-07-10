class Solution {
    void helper(int n, Deque<Character> s, String str, List<String> ans) {
        // base case
        if(n == 0) {
            while(!s.isEmpty()) {
                s.pop();
                str += ')';
            }
            ans.add(str);
            return;
        }

        if(s.isEmpty()) {
            s.push('(');
            helper(n-1, new ArrayDeque<>(s), new String(str + '('), ans);
        }
        else {
            // add another open paranthesis
            Deque<Character> s2 = new ArrayDeque<>(s); // copy the stack for recursion
            s2.push('(');
            helper(n-1, s2, new String(str + '('), ans);

            // add a closed paranthesis
            s.pop();
            helper(n, s, new String(str + ')'), ans);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, new ArrayDeque<>(), new String(""), ans);
        return ans;
    }
}